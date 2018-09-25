package com.example.rngesus.controllers;

import com.example.rngesus.models.Inventory;
import com.example.rngesus.models.Item;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.InventoryDao;
import com.example.rngesus.models.data.ItemDao;
import com.example.rngesus.models.enumerations.ItemType;
import com.example.rngesus.models.forms.TradeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Key;
import java.util.*;

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
        String partnerName = "All Items";

        if (playerCharacter == null) {
            model.addAttribute("title", "Character Not Found");
            model.addAttribute("message", "The character you're looking for doesn't exist");

            return "error";
        } else if (id == 0) {
            model.addAttribute("title", "Buy Items");
            model.addAttribute("exchange", "Shopping Cart");
        } else {
            partnerName = partnerInventory.getPlayerCharacter().getName();
            model.addAttribute("title", "Trade Items");
            model.addAttribute("exchange", "Trade Offered");
        }

//        List<Item> currencies = itemDao.getCurrency(characterId);
//        Inventory nonCurrency = inventoryDao.getNonCurrency(characterId).get(0);

        model.addAttribute("character", playerCharacter);
//        model.addAttribute("playerCurrency", currencies);
//        model.addAttribute("playerItems", nonCurrency);
        model.addAttribute("partnerInventory", partnerInventory);
        model.addAttribute("partnerName", partnerName);
        TradeForm form = new TradeForm(characterId, id, new ArrayList<Item>());
        model.addAttribute("form", form);

        return "inventory/index";

    }



    @RequestMapping(value = "/{characterId}/add/{itemId}", method = RequestMethod.GET)
    public String viewInventory(Model model, @PathVariable int characterId, @PathVariable int itemId, @RequestParam(defaultValue = "1") int qty) {

        Item item = itemDao.findById(itemId).orElseGet(null);
        Inventory inventory = inventoryDao.findByPlayerCharacterId(characterId).get(0);

        if (item == null) {
        } else if(inventory == null) {
        } else {
            inventory.addItems(item, qty);
            inventoryDao.save(inventory);
        }

        return "redirect:/inventory/" + characterId;

    }



    @RequestMapping(value = "/{characterId}/weight", method = RequestMethod.GET)
    public String verifyWeight(Model model, @PathVariable int characterId) {

        Inventory inventory = inventoryDao.findByPlayerCharacterId(characterId).get(0);


        if(inventory == null) {
        } else {
            inventory.calculateWeight();

            inventoryDao.save(inventory);
        }

        return "redirect:/inventory/" + characterId;

    }


}
