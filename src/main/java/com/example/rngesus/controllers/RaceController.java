package com.example.rngesus.controllers;

import com.example.rngesus.models.data.RaceDao;
import com.example.rngesus.models.Race;
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
@RequestMapping("race")
public class RaceController {


    @Autowired
    RaceDao raceDao;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {
        model.addAttribute("title", "Races");
        model.addAttribute("races", raceDao.findAll());
        return "race/index";
    }


}
