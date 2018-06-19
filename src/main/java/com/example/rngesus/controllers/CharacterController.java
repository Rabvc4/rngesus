package com.example.rngesus.controllers;

import com.example.rngesus.models.character.PlayerCharacter;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.RaceDao;
import com.example.rngesus.models.races.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("character")
public class CharacterController {

    @Autowired
    CharacterDao characterDao;

    @Autowired
    RaceDao raceDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("characters", characterDao.findAll());
        model.addAttribute("title", "My Characters");

        return "character/index";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String displayCreateCharacterForm(Model model) {
        model.addAttribute("title", "Create Character");
        model.addAttribute(new PlayerCharacter());
        model.addAttribute("races", raceDao.findAll());
        return "character/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String processCreateCharacterForm(@ModelAttribute  @Valid PlayerCharacter newPlayerCharacter,
                                       Errors errors, @RequestParam int raceId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Character Creator");
            model.addAttribute("races", raceDao.findAll());
            return "character/create";
        }

        Race race = raceDao.findById(raceId).orElse(null);
        newPlayerCharacter.setRace(race);
        characterDao.save(newPlayerCharacter);
        return "redirect:";
    }

    @RequestMapping(value = "race", method = RequestMethod.GET)
    public String race(Model model, @RequestParam int id) {

        Race race = raceDao.findById(id).orElse(null);
        List<PlayerCharacter> playerCharacters = race.getPlayerCharacters();
        model.addAttribute("characters", playerCharacters);
        model.addAttribute("title", race.getName() + " Characters");
        return "character/index";
    }

}
