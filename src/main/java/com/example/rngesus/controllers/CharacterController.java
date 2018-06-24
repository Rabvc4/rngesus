package com.example.rngesus.controllers;

import com.example.rngesus.models.data.ClassDao;
import com.example.rngesus.models.CharacterClass;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.RaceDao;
import com.example.rngesus.models.Race;
import com.example.rngesus.models.forms.CreateCharacterForm;
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
    ClassDao classDao;

    @Autowired
    RaceDao raceDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("characters", characterDao.findAll());
        model.addAttribute("title", "My Characters");

        return "character/index";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String addClass(Model model) {

        model.addAttribute("title", "Create Character");
        PlayerCharacter playerCharacter = new PlayerCharacter();
        CreateCharacterForm form = new CreateCharacterForm(playerCharacter, raceDao.findAll(), classDao.findAll());
        model.addAttribute("form", form);

        return "character/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String processCreateCharacterForm(@ModelAttribute  @Valid CreateCharacterForm form, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Character Creator");
            model.addAttribute("form", form);
            return "character/create";
        }

        System.out.println("Character Id: " + form.getCharacterId());
        System.out.println("playerCharacter Name: " + form.getPlayerCharacter().getName());

        PlayerCharacter newPlayerCharacter = characterDao.findById(form.getCharacterId()).orElse(null);
        Race race = raceDao.findById(form.getRaceId()).orElse(null);
        CharacterClass aClass = classDao.findById(form.getClassId()).orElse(null);


        if(race != null) {
            newPlayerCharacter.setRace(race);
        }
        if(aClass != null) {
            newPlayerCharacter.addClass(aClass);
        }

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

    @RequestMapping(value = "class", method = RequestMethod.GET)
    public String characterClass(Model model, @RequestParam int id) {

        CharacterClass aClass = classDao.findById(id).orElse(null);
        List<PlayerCharacter> playerCharacters = aClass.getPlayerCharacters();
        model.addAttribute("characters", playerCharacters);
        model.addAttribute("title", aClass.getName() + " Characters");
        return "class/index";
    }

}
