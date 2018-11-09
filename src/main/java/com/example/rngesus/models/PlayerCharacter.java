package com.example.rngesus.models;

import com.example.rngesus.models.stats.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class PlayerCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min=2, max=50)
    private String name;

    @ManyToOne
    private User user;

    @ManyToOne
    private Race race;

    private Integer experience = 0;

    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "inventory_id"))
    @MapKeyJoinColumn(name = "item_id")
    @Column(name = "classes")
    private Map<CharacterClass, ClassLevel> classes = new HashMap<>();

    private Integer currentLevel;

    @Embedded
    private AbilityScores abilityScores;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public PlayerCharacter() { }

    public PlayerCharacter(@NotNull @Size(min = 2, max = 50) String name, User user, Race race, AbilityScores abilityScores) {
        this.name = name;
        this.user = user;
        this.race = race;
        this.abilityScores = abilityScores;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void addClass(ClassLevel classLevel) {
        this.classes.put(classLevel.getBaseClass(), classLevel);
        this.setCurrentLevel();
    }

    public void addClasses(Iterable<ClassLevel> classLevels) {
        for (ClassLevel classLevel : classLevels) {
            this.classes.put(classLevel.getBaseClass(), classLevel);
        }
        this.setCurrentLevel();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AbilityScores getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(AbilityScores abilityScores) {
        this.abilityScores = abilityScores;
    }

    public Strength getStrength() {
        return this.abilityScores.getStrength();
    }

    public void setStrength(Integer integer) {
        this.abilityScores.setStrength(integer);
    }

    public void setStrength(Strength strength) {
        this.abilityScores.setStrength(strength);
    }

    public Dexterity getDexterity() {
        return this.abilityScores.getDexterity();
    }

    public void setDexterity(Integer integer) {
        this.abilityScores.setDexterity(integer);
    }

    public void setDexterity(Dexterity dexterity) {
        this.abilityScores.setDexterity(dexterity);
    }

    public Constitution getConstitution() {
        return this.abilityScores.getConstitution();
    }

    public void setConstitution(Integer integer) {
        this.abilityScores.setConstitution(integer);
    }

    public void setConstitution(Constitution constitution) {
        this.abilityScores.setConstitution(constitution);
    }

    public Wisdom getWisdom() {
        return this.abilityScores.getWisdom();
    }

    public void setWisdom(Integer integer) {
        this.abilityScores.setWisdom(integer);
    }

    public void setWisdom(Wisdom wisdom) {
        this.abilityScores.setWisdom(wisdom);
    }

    public Intelligence getIntelligence() {
        return this.abilityScores.getIntelligence();
    }

    public void setIntelligence(Integer integer) {
        this.abilityScores.setIntelligence(integer);
    }

    public void setIntelligence(Intelligence intelligence) {
        this.abilityScores.setIntelligence(intelligence);
    }

    public Charisma getCharisma() {
        return this.abilityScores.getCharisma();
    }

    public void setCharisma(Integer integer) {
        this.abilityScores.setCharisma(integer);
    }

    public void setCharisma(Charisma charisma) {
        this.abilityScores.setCharisma(charisma);
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void addExperience(Integer experience) {
        this.experience += experience;
    }

    public void subtractExperience(Integer experience) {
        this.experience -= experience;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public Integer setCurrentLevel() {
        Integer newLevel = 0;
        Iterator it = this.classes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            ClassLevel level = (ClassLevel) pair.getValue();

            newLevel += level.getLevel();
        }

        this.currentLevel = newLevel;
        return newLevel;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        if (inventory == null) {
            if (this.inventory != null) {
                this.inventory.setPlayerCharacter(null);
            }
        }
        else {
            inventory.setPlayerCharacter(this);
        }
        this.inventory = inventory;
    }


//    public void addItem(Item item) {
//        this.inventory.addItem(item);
//    }
//
//    public void addItem(Item item, Integer x) {
//        this.inventory.addItem(item, x);
//    }
//
//    public void removeItem(Item item) {
//        this.inventory.removeItem(item);
//    }




}
