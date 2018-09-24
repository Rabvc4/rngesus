package com.example.rngesus.controllers;

import com.example.rngesus.models.Inventory;
import com.example.rngesus.models.Item;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.data.CharacterDao;
import com.example.rngesus.models.data.InventoryDao;
import com.example.rngesus.models.data.ItemDao;
import com.example.rngesus.models.forms.TradeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
            model.addAttribute("exchange", "Purchased Goods");
        } else {
            partnerName = partnerInventory.getPlayerCharacter().getName();
            model.addAttribute("title", "Trade Items");
            model.addAttribute("exchange", "Trade Offered");
        }


        model.addAttribute("character", playerCharacter);
        model.addAttribute("partnerInventory", partnerInventory);
        model.addAttribute("partnerName", partnerName);
        TradeForm form = new TradeForm(characterId, id, new ArrayList<Item>());
        model.addAttribute("form", form);


        return "inventory/index";


    }

    @RequestMapping(value="/{characterId}/trade", method=RequestMethod.POST)
    public String processTrade(Model model, @PathVariable int characterId, @ModelAttribute @Valid TradeForm form, Errors errors) {

        System.out.println("Trade Path Reached");

        if (errors.hasErrors()) {
            System.out.println("Form has errors");

            Integer i = 0;

            System.out.println("-------------- Begin Errors --------------");
            for (ObjectError error : errors.getAllErrors()) {
                i += 1;
                System.out.println("Error" + i + ": " + error);
            }
            System.out.println("-------------- End Errors --------------");


            model.addAttribute("title", "Manage Inventory");

            return "inventory/index";
        }


        System.out.println("No errors");
        System.out.println("Inventory size: " + form.getItems().size());
        Iterator it = form.getItems().iterator();
        while (it.hasNext()) {
            Item item = (Item)it.next();
            System.out.println("Item ID: " + item.getId());
            System.out.println("Item description: " + item.getDescription());
//            System.out.println(pair.getKey() + " = " + pair.getValue());
//            it.remove(); // avoids a ConcurrentModificationException
        }

        System.out.println("End of item loop");
//        PlayerCharacter playerCharacter = characterDao.findById(characterId).orElseGet(null);

//        characterDao.save(playerCharacter);

        return "redirect:/inventory/" + characterId;
    }

}
