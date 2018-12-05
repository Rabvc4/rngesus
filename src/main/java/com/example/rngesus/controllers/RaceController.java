package com.example.rngesus.controllers;

import com.example.rngesus.models.Race;
import com.example.rngesus.models.data.RaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

        if (id != 0) {
            Race race = raceDao.findById(id).orElse(null);
            if (race != null) {
                model.addAttribute("title", race.getName());
                model.addAttribute("race", race);

                return "race/details";
            } else {
                model.addAttribute("title", "No Such Race");
                model.addAttribute("message", "That race does not yet exist, maybe that's where you come in?");

                return "error";
            }

        }

        model.addAttribute("title", "Races");
        model.addAttribute("races", raceDao.findAll());

        return "race/index";
    }



    @RequestMapping(value = "{raceName}", method = RequestMethod.GET)
    public String details(Model model, @PathVariable String raceName) {

        try {
            Race race = raceDao.findByName(raceName).get(0);
            model.addAttribute("title", race.getName());
            model.addAttribute("race", race);

            return "race/details";
        } catch(IndexOutOfBoundsException exception) {
            model.addAttribute("title", "No Such Race");
            model.addAttribute("message", "That race does not yet exist, maybe that's where you come in?");

            return "error";
        }

    }

}
