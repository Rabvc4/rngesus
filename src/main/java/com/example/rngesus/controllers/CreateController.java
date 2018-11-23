package com.example.rngesus.controllers;

import com.example.rngesus.models.*;
import com.example.rngesus.models.data.*;
import com.example.rngesus.models.enumerations.*;
import com.example.rngesus.models.forms.CreateCharacterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("create")
public class CreateController {


    @Autowired
    CharacterDao characterDao;

    @Autowired
    ClassDao classDao;

    @Autowired
    ClassLevelDao classLevelDao;

    @Autowired
    RaceDao raceDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    InventoryDao inventoryDao;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("title", "Create");

        return "create/index";
    }


//    TODO - Add inventoryDAO to controller

    @RequestMapping(value = "character", method = RequestMethod.GET)
    public String createCharacter(Model model) {

        model.addAttribute("title", "Character Creator");
        PlayerCharacter playerCharacter = new PlayerCharacter();
        CreateCharacterForm form = new CreateCharacterForm(playerCharacter, raceDao.findAll(), classDao.findAll());
        model.addAttribute("form", form);

        return "create/character";
    }

//    TODO - Add inventoryDAO to controller

    @RequestMapping(value = "character", method = RequestMethod.POST)
    public String processCreateCharacterForm(@CookieValue("user") String username, @ModelAttribute @Valid CreateCharacterForm form, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Character Creator");
            model.addAttribute("form", form);

            return "create/character";
        }

        PlayerCharacter newPlayerCharacter = form.getPlayerCharacter();
        User user = userDao.findByUsername(username).get(0);
        Race race = raceDao.findById(form.getRaceId()).orElse(null);

        CharacterClass aClass = classDao.findById(form.getClassId()).orElse(null);
        ClassLevel classLevel = aClass.getClassLevels().get(form.getLevel());


        Inventory inventory = new Inventory();

        newPlayerCharacter.setUser(user);
        newPlayerCharacter.setRace(race);
        newPlayerCharacter.addClass(classLevel);
        newPlayerCharacter.setInventory(inventory);
        inventory.setPlayerCharacter(newPlayerCharacter);

        characterDao.save(newPlayerCharacter);

        return "redirect:/character";
    }



    @RequestMapping(value = "class", method = RequestMethod.GET)
    public String createClass(Model model) {
        model.addAttribute(new CharacterClass());
        model.addAttribute("title", "Create Class");
        model.addAttribute("hitDiceTypes", HitDiceType.values());
        model.addAttribute("skillTypes", SkillType.values());
        model.addAttribute("savingThrows", AbilityScoreType.values());
        model.addAttribute("armorProficiencies", ArmorProficiency.values());
        model.addAttribute("weaponProficiencies", WeaponProficiency.values());

        return "create/class";
    }

    @RequestMapping(value = "class", method = RequestMethod.POST)
    public String processCreateClass(Model model, @ModelAttribute @Valid CharacterClass characterClass, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Class");
            model.addAttribute("hitDiceTypes", HitDiceType.values());
            model.addAttribute("skillTypes", SkillType.values());
            model.addAttribute("savingThrows", AbilityScoreType.values());
            model.addAttribute("armorProficiencies", ArmorProficiency.values());
            model.addAttribute("weaponProficiencies", WeaponProficiency.values());

            return "create/class";
        }

        classDao.save(characterClass);

        return "redirect:/create/classlevel";
    }



    @RequestMapping(value = "classlevel", method = RequestMethod.GET)
    public String createClassLevel(Model model, @RequestParam(defaultValue = "0") int id) {

        if (id == 0) {
            model.addAttribute("selected", "Please select");
        } else {
            CharacterClass characterClass = classDao.findById(id).orElseGet(null);
            model.addAttribute("selected", characterClass);
            model.addAttribute("class", characterClass);
        }

        model.addAttribute(new ClassLevel());
        model.addAttribute("title", "Create Class Level");
        model.addAttribute("classes", classDao.findAll());
        model.addAttribute("levels", ExperienceLevel.values());


        return "create/classlevel";
    }

    @RequestMapping(value = "classlevel", method = RequestMethod.POST)
    public String processCreateClassLevel(Model model, @ModelAttribute @Valid ClassLevel classLevel, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Class Level");
            model.addAttribute("levels", ExperienceLevel.values());
            model.addAttribute("classes", classDao.findAll());
            model.addAttribute("selected", classLevel.baseClass);


            return "create/classlevel";
        }

        classLevelDao.save(classLevel);

        return "redirect:/create/classlevel/?id=" + classLevel.baseClass.getId();
    }



    @RequestMapping(value = "race", method = RequestMethod.GET)
    public String createRace(Model model) {
        model.addAttribute(new Race());
        model.addAttribute("title", "Create Race");
        model.addAttribute("sizes", SizeType.values());

        return "create/race";
    }

    @RequestMapping(value = "race", method = RequestMethod.POST)
    public String processCreateRace(Model model, @ModelAttribute @Valid Race race, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Race");
            model.addAttribute("sizes", SizeType.values());

            return "create/race";
        }

        raceDao.save(race);

        return "redirect:/race";
    }



    @RequestMapping(value = "item", method = RequestMethod.GET)
    public String createItem(Model model) {
        model.addAttribute(new Item());
        model.addAttribute("title", "Create Item");
        model.addAttribute("itemTypes", ItemType.values());
        model.addAttribute("rarityTypes", RarityType.values());

        return "create/item";
    }

    @RequestMapping(value = "item", method = RequestMethod.POST)
    public String processCreateItem(Model model, @ModelAttribute @Valid Item item, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Item");
            model.addAttribute("itemTypes", ItemType.values());
            model.addAttribute("rarityTypes", RarityType.values());

            return "create/item";
        }

        itemDao.save(item);

        return "redirect:/item";
    }

}
