package com.example.rngesus.controllers;

import com.example.rngesus.models.*;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.ClassDao;
import com.example.rngesus.models.data.RaceDao;
import com.example.rngesus.models.data.UserDao;
import com.example.rngesus.models.enumerations.HitDiceType;
import com.example.rngesus.models.forms.CreateCharacterForm;
import com.example.rngesus.models.stats.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("create")
public class CreateController {


    @Autowired
    CharacterDao characterDao;

    @Autowired
    ClassDao classDao;

    @Autowired
    RaceDao raceDao;

    @Autowired
    UserDao userDao;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("title", "Create");

        return "create/index";
    }



    @RequestMapping(value = "character", method = RequestMethod.GET)
    public String createCharacter(Model model) {

        model.addAttribute("title", "Character Creator");
        PlayerCharacter playerCharacter = new PlayerCharacter();
        CreateCharacterForm form = new CreateCharacterForm(playerCharacter, raceDao.findAll(), classDao.findAll());
        model.addAttribute("form", form);

        return "create/character";
    }

    @RequestMapping(value = "character", method = RequestMethod.POST)
    public String processCreateCharacterForm(@CookieValue("user") String username, @ModelAttribute @Valid CreateCharacterForm form, Errors errors, Model model) {

        if (errors.hasErrors()) {
            int i = 0;
            System.out.println("----------------- Had errors -----------------\n");

            for (ObjectError error : errors.getAllErrors()) {
                i++;
                System.out.println("Error " + i + ":-----------------\n" + error.toString() + "\nError " + i + ":-----------------\n");
            }

            model.addAttribute("title", "Character Creator");
            model.addAttribute("form", form);

            return "create/character";
        }

        PlayerCharacter newPlayerCharacter = form.getPlayerCharacter();
        User user = userDao.findByUsername(username).get(0);
        Race race = raceDao.findById(form.getRaceId()).orElse(null);
        CharacterClass aClass = classDao.findById(form.getClassId()).orElse(null);

        newPlayerCharacter.setUser(user);
        newPlayerCharacter.setRace(race);
        newPlayerCharacter.addClass(aClass);

        characterDao.save(newPlayerCharacter);

        return "redirect:/character";
    }



    @RequestMapping(value = "class", method = RequestMethod.GET)
    public String createClass(Model model) {
        model.addAttribute(new CharacterClass());
        model.addAttribute("title", "Create Class");
        model.addAttribute("hitDiceTypes", HitDiceType.values());

        return "create/class";
    }

    @RequestMapping(value = "class", method = RequestMethod.POST)
    public String processCreateClass(Model model, @ModelAttribute @Valid CharacterClass characterClass, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Class");
            model.addAttribute("hitDiceTypes", HitDiceType.values());

            return "create/class";
        }

        classDao.save(characterClass);

        return "redirect:/class";
    }



    @RequestMapping(value = "race", method = RequestMethod.GET)
    public String createRace(Model model) {
        model.addAttribute(new Race());
        model.addAttribute("title", "Create Race");

        return "create/race";
    }

    @RequestMapping(value = "race", method = RequestMethod.POST)
    public String processCreateRace(Model model, @ModelAttribute @Valid Race race, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Race");

            return "create/race";
        }

        raceDao.save(race);

        return "redirect:/race";
    }

}
