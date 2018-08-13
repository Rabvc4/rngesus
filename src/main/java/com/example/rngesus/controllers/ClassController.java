package com.example.rngesus.controllers;

import com.example.rngesus.models.data.ClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("class")
public class ClassController {


    @Autowired
    ClassDao classDao;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {
        model.addAttribute("title", "Classes");
        model.addAttribute("classes", classDao.findAll());
        return "class/index";
    }

}
