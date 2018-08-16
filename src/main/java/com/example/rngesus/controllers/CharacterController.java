package com.example.rngesus.controllers;

import com.example.rngesus.models.*;
import com.example.rngesus.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    InventoryDao inventoryDao;




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

        return "race/index";
    }



    @RequestMapping(value = "class", method = RequestMethod.GET)
    public String characterClass(Model model, @RequestParam int id) {

        CharacterClass aClass = classDao.findById(id).orElse(null);
        List<PlayerCharacter> playerCharacters = aClass.getPlayerCharacters();
        model.addAttribute("characters", playerCharacters);
        model.addAttribute("title", aClass.getName() + " Characters");

        return "class/index";
    }



    @RequestMapping(value = "inventory", method = RequestMethod.GET)
    public String characterInventory(Model model, @RequestParam int id, @CookieValue("user") String username) {

        if(username != null) {

            User user = userDao.findByUsername(username).get(0);

            if (id == user.getId()) {
                Inventory inventory = inventoryDao.findById(id).orElse(null);
                List<Item> items = inventory.getItems();
                model.addAttribute("items", items);
                model.addAttribute("title", inventory.getPlayerCharacter() + "'s Inventory");

                return "inventory/details";

            }
            model.addAttribute("title", "404 Not Found");
            model.addAttribute("content", "You can't edit an inventory that doesn't exist.");

            return "error";

        }

        return "redirect:/user/login";
    }


}
