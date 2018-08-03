package com.example.rngesus.controllers;

import com.example.rngesus.models.*;
import com.example.rngesus.models.data.ClassDao;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.RaceDao;
import com.example.rngesus.models.data.UserDao;
import com.example.rngesus.models.forms.CreateCharacterForm;
import com.example.rngesus.models.stats.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String index(Model model, @CookieValue("user") String username) {


        if(username != null) {

            User user = userDao.findByUsername(username).get(0);
            model.addAttribute("characters", characterDao.findByUserId(user.getId()));
            model.addAttribute("title", "My Characters");

            return "character/index";
        }

        model.addAttribute("message", "You'll need to login to view characters");

        return "redirect:/user/login";
    }



    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String addClass(Model model) {

        model.addAttribute("title", "Character Creator");
        PlayerCharacter playerCharacter = new PlayerCharacter();
        CreateCharacterForm form = new CreateCharacterForm(playerCharacter, raceDao.findAll(), classDao.findAll());
        model.addAttribute("form", form);

        return "character/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String processCreateCharacterForm(@CookieValue("user") String username, @ModelAttribute  @Valid CreateCharacterForm form, Errors errors, Model model) {

        if (errors.hasErrors()) {
            int i = 0;
            System.out.println("----------------- Had errors -----------------\n");

            for (ObjectError error : errors.getAllErrors()) {
                i++;
                System.out.println("Error " + i + ":-----------------\n" + error.toString() + "\nError " + i + ":-----------------\n");
            }

            model.addAttribute("title", "Character Creator");
            model.addAttribute("form", form);
            return "character/create";
        }

//        Test stuff

        System.out.println("Made it past errors");

        Strength strength = new Strength(8);
        Dexterity dexterity = new Dexterity(8);
        Constitution constitution = new Constitution(8);
        Wisdom wisdom = new Wisdom(8);
        Intelligence intelligence = new Intelligence(8);
        Charisma charisma = new Charisma(8);

        System.out.println("Strength: " + strength.getValue());
        System.out.println("Strength Mod: " + strength.getModifier());

//        End Test stuff

        User user = userDao.findByUsername(username).get(0);

        PlayerCharacter newPlayerCharacter = form.getPlayerCharacter();
        Race race = raceDao.findById(form.getRaceId()).orElse(null);
        CharacterClass aClass = classDao.findById(form.getClassId()).orElse(null);

        AbilityScores abilityScores = new AbilityScores(strength, dexterity, constitution, wisdom, intelligence, charisma);

        newPlayerCharacter.setUser(user);
        newPlayerCharacter.setRace(race);
        newPlayerCharacter.addClass(aClass);
        newPlayerCharacter.setAbilityScores(abilityScores);



        System.out.println("Character Strength: " + newPlayerCharacter.getStrength());

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
