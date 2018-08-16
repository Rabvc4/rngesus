package com.example.rngesus.controllers;

import com.example.rngesus.models.Item;
import com.example.rngesus.models.data.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("item")
public class ItemController {


    @Autowired
    ItemDao itemDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {
        model.addAttribute("title", "Races");
        model.addAttribute("races", raceDao.findAll());
        return "race/index";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String viewAccount(Model model, @PathVariable String name) {

        Item item = itemDao.findByName(name).get(0);
        if (item != null) {

//            TODO - Delete Test Code
            System.out.println("Item not null");
//            TODO - Delete Test Code

            model.addAttribute("item", item);
            model.addAttribute("title", item.getName());

            return "user/account";
        }

//            TODO - Delete Test Code
        System.out.println("Item null");
//            TODO - Delete Test Code

        model.addAttribute("title", "Da Fuq?");
        model.addAttribute("content", "What do you think this is, Google? Get your shit together and try again.");


        return "error";
    }

}
