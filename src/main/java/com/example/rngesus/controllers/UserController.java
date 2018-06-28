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
    public String create(@ModelAttribute @Valid User user, Errors errors, Model model, String verify) throws InvalidKeySpecException, NoSuchAlgorithmException {

        List<User> sameName = userDao.findByUsername(user.getUsername());
        String inputPassword = user.getPassword();

        if(!errors.hasErrors() && inputPassword.equals(verify) && sameName.isEmpty()) {

            System.out.println("No errors");

            user.setPassword(encryptedPassword(inputPassword));
            userDao.save(user);

            return "user/index";

        } else {

            System.out.println("Errors detected");

            model.addAttribute("title", "Join RNGesus");
            model.addAttribute("user", user);

            if(!inputPassword.equals(verify)) {
                model.addAttribute("verify", "Passwords do not match");
            }
            if(!sameName.isEmpty()) {
                model.addAttribute("message", "That username is already taken, please choose another one");
            }

            return "user/create";
        }
    }



    @RequestMapping(value = "login")
    public String loginForm(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute(new User());
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLogin(Model model, @ModelAttribute User user, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {

        System.out.println("Login handler used");

        List<User> u = userDao.findByEmail(user.getEmail());
        User registeredUser = u.get(0);

        if (validPassword(user.getPassword(), registeredUser.getPassword())) {
            Cookie c = new Cookie("user", user.getUsername());
            c.setPath("/");
            response.addCookie(c);
            return "redirect:/user/index";
        } else {
            model.addAttribute("message", "Invalid Password");
            model.addAttribute("title", "Login");
            return "user/login";
        }
    }



    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
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



    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String viewAccount(Model model, @PathVariable int userId) {

        User user = userDao.findById(userId).orElse(null);
        model.addAttribute("user", user);

        return "user/account";
    }

}
