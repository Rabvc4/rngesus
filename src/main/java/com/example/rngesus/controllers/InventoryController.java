package com.example.rngesus.controllers;

import com.example.rngesus.models.Inventory;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.InventoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("inventory")
public class InventoryController {


    @Autowired
    InventoryDao inventoryDao;

    @Autowired
    CharacterDao characterDao;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String viewInventory(Model model, @PathVariable int id) {

        try {
            Inventory inventory = inventoryDao.findByPlayerCharacterId(id).get(0);
            model.addAttribute("title", "Manage Inventory");
            model.addAttribute("inventory", inventory);

            return "inventory/index";

        } catch (IndexOutOfBoundsException e) {
            model.addAttribute("title", "That's Not A Thing");
            model.addAttribute("message", "I would know if that were a thing...");

            return "error";
        }
    }

    @RequestMapping(value = "trade/{id}", method = RequestMethod.GET)
    public String trade(Model model, @PathVariable int characterId, @RequestParam int partnerId) {

//        PlayerCharacter playerCharacter = characterDao.findById(characterId).orElseGet(null);
//
//        try {
//            Inventory inventory = inventoryDao.findByPlayerCharacterId(id).get(0);
//            model.addAttribute("title", "Manage Inventory");
//            model.addAttribute("character", playerCharacter);
//            model.addAttribute("inventory", inventory);
//
//            return "inventory/index";
//
//        } catch (IndexOutOfBoundsException e) {
//            model.addAttribute("title", "Starting Inventory");
//            model.addAttribute("character", playerCharacter);
//            model.addAttribute("inventory", new Inventory());
//
//            return "inventory/index";
//        }

        model.addAttribute("title", "Trade Screen");
        model.addAttribute("message", "Well, you found the trade screen, but it isn't setup yet.");

        return "error";

    }

}
