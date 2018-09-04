package com.example.rngesus.controllers;

import com.example.rngesus.models.Inventory;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.InventoryDao;
import com.example.rngesus.models.data.ItemDao;
import com.example.rngesus.models.forms.TradeForm;
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
        Inventory partnerInventory = inventoryDao.findById(id).orElse(new Inventory(itemDao.findAll()));
        String partnerName;

        if (playerCharacter == null) {
            model.addAttribute("title", "Character Not Found");
            model.addAttribute("message", "The character you're looking for doesn't exist");

            return "error";
        } else if (partnerInventory.getPlayerCharacter() == null) {
            partnerName = "All Items";
            model.addAttribute("title", "Buy Items");
            model.addAttribute("exchange", "Purchased Goods");
        } else {
            partnerName = partnerInventory.getPlayerCharacter().getName();
            model.addAttribute("title", "Trade Items");
            model.addAttribute("exchange", "Trade Offered");
        }

        TradeForm form = new TradeForm(playerCharacter.getInventory(), partnerInventory, playerCharacter.getName(), partnerName);

        model.addAttribute("form", form);


        return "inventory/index";


    }

    @RequestMapping(value="/{characterId}/trade", method=RequestMethod.POST)
    public String processTrade(Model model, @PathVariable int characterId, @ModelAttribute @Valid TradeForm tradeForm, Errors errors) {

        System.out.println("Trade Path Reached");

        if (errors.hasErrors()) {
            model.addAttribute("title", "Manage Inventory");
            model.addAttribute("form", tradeForm);


            return "inventory/index";
        }

        PlayerCharacter playerCharacter = characterDao.findById(characterId).orElseGet(null);

//        characterDao.save(playerCharacter);

        return "inventory/index";
    }

}
