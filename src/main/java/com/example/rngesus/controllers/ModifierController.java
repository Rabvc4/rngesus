package com.example.rngesus.controllers;

import com.example.rngesus.models.Modifier;
import com.example.rngesus.models.ModifierSubType;
import com.example.rngesus.models.ModifierType;
import com.example.rngesus.models.data.ModifierDao;
import com.example.rngesus.models.data.ModifierSubTypeDao;
import com.example.rngesus.models.data.ModifierTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("modifier")
public class ModifierController {


    @Autowired
    ModifierDao modifierDao;

    @Autowired
    ModifierTypeDao modifierTypeDao;

    @Autowired
    ModifierSubTypeDao modifierSubTypeDao;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {

        if (id != 0) {
            Modifier modifier = modifierDao.findById(id).orElse(null);
            if (modifier != null) {
                model.addAttribute("title", "Modifier Details");
                model.addAttribute("modifier", modifier);

                return "modifier/details";
            }
        }

        model.addAttribute("title", "That isn't a modifier...");
        model.addAttribute("message", "Quit being weird and just make it yourself.");

        return "error";
    }



    @RequestMapping(value = "type", method = RequestMethod.GET)
    public String type(Model model, @RequestParam(defaultValue = "0") int id) {

        if (id != 0) {
            ModifierType modifierType = modifierTypeDao.findById(id).orElse(null);
            if (modifierType != null) {
                model.addAttribute("title", modifierType.getName());
                model.addAttribute("type", modifierType);

                return "modifier/type";
            }
        }

        model.addAttribute("title", "Modifier Types");
        model.addAttribute("types", modifierTypeDao.findAll());

        return "modifier/index";
    }



    @RequestMapping(value = "subtype", method = RequestMethod.GET)
    public String subType(Model model, @RequestParam(defaultValue = "0") int id) {

        if (id != 0) {
            ModifierSubType subType = modifierSubTypeDao.findById(id).orElse(null);
            if (subType != null) {
                model.addAttribute("title", subType.getName());
                model.addAttribute("subType", subType);

                return "modifier/subtype";
            }
        }

        model.addAttribute("title", "That isn't a modifier subtype...");
        model.addAttribute("message", "Quit being weird and just make it yourself.");

        return "error";
    }



    @RequestMapping(value = "details", method = RequestMethod.GET)
    @ResponseBody
    public List<ModifierSubType> details(@RequestParam int type) {
        return modifierSubTypeDao.findByTypesId(type);
    }
}
