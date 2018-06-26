package com.example.rngesus.controllers;

import com.example.rngesus.models.User;
import com.example.rngesus.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "create")
    public String create(Model model) {

        model.addAttribute("title", "User Signup");

        return "user/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute User user, String verify) {
        if(verify.equals(user.getPassword())) {
            model.addAttribute("user", user);
            return "user/index";
        } else {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("title", "User Signup");
            model.addAttribute("verify", "Passwords do not match");
            return "user/create";
        }
    }

    @RequestMapping(value = "view/{userId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int userId) {

        User user = userDao.findById(userId).orElse(null);
        model.addAttribute("user", user);

        return "user/view";
    }

}
