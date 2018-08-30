package com.example.rngesus.controllers;

import com.example.rngesus.models.Inventory;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.InventoryDao;
import com.example.rngesus.models.data.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("inventory")
public class InventoryController {


    @Autowired
    InventoryDao inventoryDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    CharacterDao characterDao;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute(new Inventory());
        model.addAttribute("title", "Inventories");
        model.addAttribute("exchange", "Exchange");
        model.addAttribute("character", "Character");
        model.addAttribute("partner", itemDao.findAll());

        return "inventory/index";
    }



    @RequestMapping(value = "/{characterId}", method = RequestMethod.GET)
    public String viewInventory(Model model, @PathVariable int characterId, @RequestParam(defaultValue = "0") int id) {

        PlayerCharacter playerCharacter = characterDao.findById(characterId).orElseGet(null);
        Inventory partnerInventory;

        if (playerCharacter == null) {
            model.addAttribute("title", "Character Not Found");
            model.addAttribute("message", "The character you're looking for doesn't exist");

            return "error";
        }

        if (id == 0) {
            partnerInventory = new Inventory(itemDao.findAll());
            model.addAttribute(new Inventory());

            model.addAttribute("partnerName", "All Items");
            model.addAttribute("partner", partnerInventory);
            model.addAttribute("character", playerCharacter);
            model.addAttribute("title", "Buy Items");
            model.addAttribute("exchange", "Purchased Goods");

            return "inventory/index";
        } else {
            try {
                partnerInventory = inventoryDao.findById(id).orElseGet(null);
                String partnerName = partnerInventory.getPlayerCharacter().getName();
                model.addAttribute(new Inventory());

                model.addAttribute("partnerName", partnerName);
                model.addAttribute("partner", partnerInventory);
                model.addAttribute("character", playerCharacter);
                model.addAttribute("title", "Trade");
                model.addAttribute("exchange", "Purchased Goods");

                return "inventory/index";
            } catch (IndexOutOfBoundsException e) {
                model.addAttribute("title", "Nope");
                model.addAttribute("message", "You can't trade with someone who doesn't exist");

                return "error";
            }
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



    @RequestMapping(value="/{characterId}/exchange", method=RequestMethod.POST)
    public String processExchange(Model model, @PathVariable int characterId, @ModelAttribute @Valid Inventory inventory, Errors errors) {

        System.out.println("Exchange Path Reached");

        if (errors.hasErrors()) {
            model.addAttribute("title", "Manage Inventory");
            model.addAttribute("inventory", inventory);


            return "inventory/index";
        }

        PlayerCharacter playerCharacter = characterDao.findById(characterId).orElseGet(null);

        characterDao.save(playerCharacter);

        return "inventory/index";
    }

}
