package com.example.rngesus.controllers;

import com.example.rngesus.models.Inventory;
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



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int id) {

        Inventory inventory = inventoryDao.findById(id).orElse(null);
        model.addAttribute("inventory", inventory);

        return "inventory/index";
    }

}
