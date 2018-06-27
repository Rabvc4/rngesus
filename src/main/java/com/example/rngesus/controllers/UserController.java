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
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "Registered Users");


        return "user/index";
    }

    @RequestMapping(value = "create")
    public String create(Model model) {

        model.addAttribute("title", "Join RNGesus");
        User user = new User();
        model.addAttribute("user", user);
        return "user/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute  @Valid User user, Errors errors, Model model, String verify) {

        List<User> sameName = userDao.findByUsername(user.getUsername());

        if(!errors.hasErrors() && user.getPassword().equals(verify) && sameName.isEmpty()) {

            model.addAttribute("title", "Got passed errors");

            return "user/index";
        } else {
            model.addAttribute("title", "Join RNGesus");
            model.addAttribute("user", user);

            if(!user.getPassword().equals(verify)) {
                model.addAttribute("verify", "Passwords didn't match");
            }
            if(!user.getPassword().equals(verify)) {
                model.addAttribute("message", "Username is taken, please select another one");
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
    public String create(Model model, @ModelAttribute User user, HttpServletResponse response) {
        List<User> u = userDao.findByUsername(user.getUsername());
        if(u.isEmpty()) {
            model.addAttribute("message", "Invalid Username");
            model.addAttribute("title", "Login");
            return "user/login";
        }

        User loggedIn = u.get(0);
        if(loggedIn.getPassword().equals(user.getPassword())) {

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
    public String viewMenu(Model model, @PathVariable int userId) {

        User user = userDao.findById(userId).orElse(null);
        model.addAttribute("user", user);

        return "user/account";
    }

}
