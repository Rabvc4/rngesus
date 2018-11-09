package com.example.rngesus.controllers;

import com.example.rngesus.models.data.SpellDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("spells")
public class SpellController {

    @Autowired
    SpellDao spellDao;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam String name) {
        model.addAttribute("title", "Spells");
        model.addAttribute("spells", spellDao.findAll());
        return "spell/index";
    }

}
