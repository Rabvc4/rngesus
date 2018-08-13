package com.example.rngesus.controllers;

import com.example.rngesus.models.CharacterClass;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.Race;
import com.example.rngesus.models.User;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.ClassDao;
import com.example.rngesus.models.data.RaceDao;
import com.example.rngesus.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

        return "redirect:/user/login";
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
