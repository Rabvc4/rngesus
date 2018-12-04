package com.example.rngesus.controllers;

import com.example.rngesus.models.Modifier;
import com.example.rngesus.models.data.ModifierDao;
import com.example.rngesus.models.data.ModifierSubTypeDao;
import com.example.rngesus.models.enumerations.ModifierType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("modifier")
public class ModifierController {


    @Autowired
    ModifierDao modifierDao;

    @Autowired
    ModifierSubTypeDao modifierSubTypeDao;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {

        if (id != 0) {
            Modifier modifier = modifierDao.findById(id).orElseGet(null);
            if (modifier != null) {
                model.addAttribute("title", modifier.getName() + " Modifier");
                model.addAttribute("modifier", modifier);

                return "modifier/details";
            }
        }

        return "traits/index";
    }


//    @RequestMapping(value = "subtype", method = RequestMethod.GET)
//    public String index(Model model, @RequestParam(defaultValue = "0") int id) {
//
//        race = raceDao.findByName(raceName).get(0);
//        model.addAttribute("title", race.getName());
//        model.addAttribute("race", race);
//
//        return "modifier/subtype";
//    }



//    @RequestMapping(value = "{name}", method = RequestMethod.GET)
//    public String details(Model model, @PathVariable String name) {
//
//        Modifier modifier = modifierDao.findByName(name).get(0);
//        model.addAttribute("title", modifier.getName());
//        model.addAttribute("trait", modifier);
//
//        return "trait/details";
//    }



}
