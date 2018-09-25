package com.example.rngesus.controllers;

import com.example.rngesus.models.Item;
import com.example.rngesus.models.data.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("item")
public class ItemController {


    @Autowired
    ItemDao itemDao;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Items");
        model.addAttribute("items", itemDao.findAll());

        return "item/index";
    }



    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String viewItem(Model model, @PathVariable String name) {

        try {
            Item item = itemDao.findByName(name).get(0);
            model.addAttribute("item", item);
            model.addAttribute("title", item.getName());

            return "item/details";

        } catch (IndexOutOfBoundsException e) {
            model.addAttribute("title", "Go Home, You're Drunk");
            model.addAttribute("message", "What do you think this is, Google? Get it together and try again.");

            return "error";
        }
    }



    @ResponseBody
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public Item details(@RequestParam int id) {

        return itemDao.findById(id).orElseGet(null);
    }

}
