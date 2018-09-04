package com.example.rngesus.controllers;

import com.example.rngesus.models.User;
import com.example.rngesus.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import static com.example.rngesus.controllers.Encryption.encryptedPassword;
import static com.example.rngesus.controllers.Encryption.validPassword;

@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    UserDao userDao;



    @RequestMapping(value = "create")
    public String create(Model model) {

        model.addAttribute("title", "Join RNGesus");
        User user = new User();
        model.addAttribute("user", user);
        return "user/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute @Valid User user, HttpServletResponse response, Errors errors, Model model, String verify) throws InvalidKeySpecException, NoSuchAlgorithmException {

        List<User> sameName = userDao.findByUsername(user.getUsername());
        String inputPassword = user.getPassword();

        if(!errors.hasErrors() && inputPassword.equals(verify) && sameName.isEmpty()) {

            user.setPassword(encryptedPassword(inputPassword));
            userDao.save(user);

            Cookie c = new Cookie("user", user.getUsername());
            c.setPath("/");
            response.addCookie(c);

            return "redirect:/user/" + user.getUsername();

        } else {

            model.addAttribute("title", "Join RNGesus");
            model.addAttribute("user", user);

            if(!inputPassword.equals(verify)) {
                model.addAttribute("verify", "Passwords do not match");
            }
            if(!sameName.isEmpty()) {
                model.addAttribute("message", "That username is taken, please choose another one");
            }

            return "user/create";
        }
    }



    @RequestMapping(value = "login")
    public String newLogin(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Login");
        model.addAttribute(new User());
        model.addAttribute("message", request.getAttribute("message"));

        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLogin(Model model, @ModelAttribute User user, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {

        List<User> targetUsername = userDao.findByEmail(user.getEmail());
        User registeredUser;

        if (targetUsername.isEmpty()) {
            model.addAttribute("message", "Invalid Password");
            return "redirect:/user/create";
        } else {
            registeredUser = targetUsername.get(0);
        }

        if (validPassword(user.getPassword(), registeredUser.getPassword())) {
            Cookie c = new Cookie("user", registeredUser.getUsername());
            c.setPath("/");
            response.addCookie(c);
            model.addAttribute("user", registeredUser);

            return "redirect:/character";

        } else {
            model.addAttribute("message", "Invalid Password");
            model.addAttribute("title", "Login");

            return "user/login";

        }
    }



    @RequestMapping(value = "logout")
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
            }
        }

        return "redirect:/user/login";
    }



    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String viewAccount(Model model, @PathVariable String username) {

        List<User> u = userDao.findByUsername(username);
        User registeredUser = u.get(0);
        model.addAttribute("user", registeredUser);

        return "user/account";
    }

}
