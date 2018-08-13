package com.example.rngesus.controllers;

import com.example.rngesus.models.data.RaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
