package com.example.rngesus.controllers;

import com.example.rngesus.models.Trait;
import com.example.rngesus.models.data.TraitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("trait")
public class TraitController {



    @Autowired
    TraitDao traitDao;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {

        if (id != 0) {
            Trait trait = traitDao.findById(id).orElseGet(null);
            if (trait != null) {
                model.addAttribute("title", trait.getName() + " Trait");
                model.addAttribute("trait", trait);

                return "traits/details";
            }
        }

        model.addAttribute("title", "That isn't a trait...");
        model.addAttribute("message", "Quit being weird.");

        return "error";
    }

}
