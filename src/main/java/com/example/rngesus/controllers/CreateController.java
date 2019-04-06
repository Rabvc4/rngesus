package com.example.rngesus.controllers;

import com.example.rngesus.models.*;
import com.example.rngesus.models.data.*;
import com.example.rngesus.models.enumerations.*;
import com.example.rngesus.models.forms.CreateCharacterForm;
import com.example.rngesus.models.forms.CreateModifierForm;
import com.example.rngesus.models.forms.CreateTraitForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;

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

    @Autowired
    TraitDao traitDao;

    @Autowired
    ModifierDao modifierDao;

    @Autowired
    ModifierTypeDao modifierTypeDao;

    @Autowired
    ModifierSubTypeDao modifierSubTypeDao;



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
            model.addAttribute("selected", classLevel.getBaseClass());


            return "create/classlevel";
        }

        classLevelDao.save(classLevel);

        return "redirect:/create/classlevel/?id=" + classLevel.getBaseClass().getId();
    }



    @RequestMapping(value = "race", method = RequestMethod.GET)
    public String createRace(Model model) {
        model.addAttribute(new Race());
        model.addAttribute("title", "Create Race");
        model.addAttribute("sizes", SizeType.values());
        model.addAttribute("abilities", AbilityScoreType.values());

        return "create/race";
    }

    @RequestMapping(value = "race", method = RequestMethod.POST)
    public String processCreateRace(Model model, @ModelAttribute @Valid Race race, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Race");
            model.addAttribute("sizes", SizeType.values());
            model.addAttribute("abilities", AbilityScoreType.values());

            return "create/race";
        }

        raceDao.save(race);

        return "redirect:/race?id=" + race.getId();
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



    @RequestMapping(value = "trait/{raceId}", method = RequestMethod.GET)
    public String createTrait(Model model, @PathVariable int raceId) {

        Race race = raceDao.findById(raceId).orElse(null);

        if (race != null) {
            Trait trait = new Trait();
            model.addAttribute("form", new CreateTraitForm(trait, race));
            model.addAttribute("title", "Add Racial Trait to " + race.getName());

            return "create/trait";
        }

        model.addAttribute("title", "That Race Doesn't Exist");
        model.addAttribute("message", "That race either no longer exists or it never existed.");

        return "error";


    }

    @RequestMapping(value = "trait", method = RequestMethod.POST)
    public String processCreateTrait(Model model, @ModelAttribute @Valid CreateTraitForm form, Errors errors) {

        for (Iterator<ObjectError> iterator = errors.getAllErrors().iterator(); iterator.hasNext(); ) {
            ObjectError error = iterator.next();
            System.out.println(error);
        }

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Racial Trait to " + form.getRace().getName());
            model.addAttribute("message", "Please correct the errors before continuing");

            return "create/trait";
        }

        Trait newTrait = form.getTrait();
        Race race = raceDao.findById(form.getRaceId()).orElse(null);
        newTrait.addRace(race);

        traitDao.save(newTrait);

        return "redirect:/race/?id=" + race.getId();
    }



    @RequestMapping(value = "modifier/{traitId}", method = RequestMethod.GET)
    public String createModifier(Model model, @PathVariable int traitId) {

        Trait trait = traitDao.findById(traitId).orElse(null);

        if (trait != null) {
            Modifier modifier = new Modifier();
            Iterable<ModifierType> modifierTypes = modifierTypeDao.findAll();
            model.addAttribute("form", new CreateModifierForm(modifier, trait, modifierTypes));
            model.addAttribute("title", "Add Modifier to " + trait.getName());

            return "create/modifier";
        }

        model.addAttribute("title", "That Trait Doesn't Exist");
        model.addAttribute("message", "That trait either no longer exists or it never existed.");

        return "error";
    }

    @RequestMapping(value = "modifier", method = RequestMethod.POST)
    public String processCreateModifier(Model model, @ModelAttribute @Valid CreateModifierForm form, Errors errors) {

        for (Iterator<ObjectError> iterator = errors.getAllErrors().iterator(); iterator.hasNext(); ) {
            ObjectError error = iterator.next();
            System.out.println(error);
        }

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Modifier to " + form.getTrait().getName());
            model.addAttribute("message", "Please correct the errors before continuing");

            return "create/modifier";
        }

        Modifier newModifier = form.getModifier();
        Trait trait = traitDao.findById(form.getTraitId()).orElse(null);
        newModifier.addTrait(trait);

        modifierDao.save(newModifier);

        return "redirect:/trait/" + newModifier.getId();
    }



    @RequestMapping(value = "modifier-type", method = RequestMethod.GET)
    public String createModifierType(Model model) {

        ModifierType modifierType = new ModifierType();
        model.addAttribute("type", modifierType);
        model.addAttribute("title", "Create Modifier Type");

        return "create/modifier-type";
    }

    @RequestMapping(value = "modifier-type", method = RequestMethod.POST)
    public String processCreateModifierType(Model model, @ModelAttribute @Valid ModifierType modifierType, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Modifier Type");

            return "create/modifier-type";
        }

        modifierTypeDao.save(modifierType);

        return "redirect:/modifier/type/?id=" + modifierType.getId();
    }



    @RequestMapping(value = "modifier-subtype", method = RequestMethod.GET)
    public String createModifierSubType(Model model) {

        ModifierSubType modifierSubType = new ModifierSubType();
        model.addAttribute("subType", modifierSubType);
        model.addAttribute("title", "Create Modifier Subtype");
        model.addAttribute("types", modifierTypeDao.findAll());

        return "create/modifier-subtype";
    }

    @RequestMapping(value = "modifier-subtype", method = RequestMethod.POST)
    public String processCreateModifierSubType(Model model, @ModelAttribute @Valid ModifierSubType modifierSubType, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Modifier Subtype");
            model.addAttribute("types", modifierTypeDao.findAll());

            return "create/modifier-subtype";
        }

        modifierSubTypeDao.save(modifierSubType);

        return "redirect:/modifier/subtype/?id=" + modifierSubType.getId();
    }
}
