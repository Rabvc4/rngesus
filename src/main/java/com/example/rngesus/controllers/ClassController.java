package com.example.rngesus.controllers;

import com.example.rngesus.models.data.ClassDao;
import com.example.rngesus.models.enumerations.HitDiceType;
import com.example.rngesus.models.forms.CharacterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("class")
public class ClassController {

    @Autowired
    ClassDao classDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {
        model.addAttribute("title", "Classes");
        model.addAttribute("classes", classDao.findAll());
        return "class/index";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute(new CharacterClass());
        model.addAttribute("title", "Create Class");
        model.addAttribute("hitDiceTypes", HitDiceType.values());
        return "class/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute @Valid CharacterClass characterClass, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Class");
            return "class/create";
        }

        classDao.save(characterClass);
        return "redirect:";
    }
}
