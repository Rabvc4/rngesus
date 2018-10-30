package com.example.rngesus.controllers;

import com.example.rngesus.models.CharacterClass;
import com.example.rngesus.models.User;
import com.example.rngesus.models.data.ClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("class")
public class ClassController {


    @Autowired
    ClassDao classDao;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {
        if (id != 0) {
            model.addAttribute("class", classDao);
            model.addAttribute("title", "Classes");

            return "class/index";

        }
        model.addAttribute("title", "Classes");
        model.addAttribute("classes", classDao.findAll());

        return "class/index";
    }

    @RequestMapping(value = "{className}", method = RequestMethod.GET)
    public String details(Model model, @PathVariable String className) {

        CharacterClass characterClass = classDao.findByName(className).get(0);
        model.addAttribute("title", characterClass.getName());
        model.addAttribute("class", characterClass);

        return "class/details";
    }

}
