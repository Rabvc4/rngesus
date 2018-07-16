package com.example.rngesus.controllers;

import com.example.rngesus.models.User;
import com.example.rngesus.models.data.ClassDao;
import com.example.rngesus.models.CharacterClass;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.RaceDao;
import com.example.rngesus.models.Race;
import com.example.rngesus.models.data.UserDao;
import com.example.rngesus.models.forms.CreateCharacterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    UserDao userDao;



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
    public String processCreateCharacterForm(@CookieValue("user") String username, @ModelAttribute  @Valid CreateCharacterForm form, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Character Creator");
            model.addAttribute("form", form);
            return "character/create";
        }

        User user = userDao.findByUsername(username).get(0);

        PlayerCharacter newPlayerCharacter = form.getPlayerCharacter();
        Race race = raceDao.findById(form.getRaceId()).orElse(null);
        CharacterClass aClass = classDao.findById(form.getClassId()).orElse(null);

        newPlayerCharacter.setUser(user);
        newPlayerCharacter.setRace(race);
        newPlayerCharacter.addClass(aClass);
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
