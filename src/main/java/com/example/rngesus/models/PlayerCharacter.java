package com.example.rngesus.models;

import com.example.rngesus.models.stats.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Target;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    private List<CharacterClass> classes = new ArrayList<CharacterClass>();

//    TODO - Make ability scores into their own class to clear up PlayerCharacter

    @Embedded
    @Target(Strength.class)
    private AbilityScore strength;

    @Embedded
    @Target(Dexterity.class)
    private AbilityScore dexterity;

    @Embedded
    @Target(Constitution.class)
    private AbilityScore constitution;

    @Embedded
    @Target(Intelligence.class)
    private AbilityScore intelligence;

    @Embedded
    @Target(Wisdom.class)
    private AbilityScore wisdom;

    @Embedded
    @Target(Charisma.class)
    private AbilityScore charisma;

    public PlayerCharacter() { }

    public PlayerCharacter(@NotNull @Size(min = 2, max = 50) String name, User user, Race race) {
        this.name = name;
        this.user = user;
        this.race = race;
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

    public List<CharacterClass> getClasses() {
        return classes;
    }

    public void addClass(CharacterClass aClass) {
        this.classes.add(aClass);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AbilityScore getStrength() {
        return strength;
    }

    public void setStrength(AbilityScore strength) {
        this.strength = strength;
    }

    public AbilityScore getDexterity() {
        return dexterity;
    }

    public void setDexterity(AbilityScore dexterity) {
        this.dexterity = dexterity;
    }

    public AbilityScore getConstitution() {
        return constitution;
    }

    public void setConstitution(AbilityScore constitution) {
        this.constitution = constitution;
    }

    public AbilityScore getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(AbilityScore intelligence) {
        this.intelligence = intelligence;
    }

    public AbilityScore getWisdom() {
        return wisdom;
    }

    public void setWisdom(AbilityScore wisdom) {
        this.wisdom = wisdom;
    }

    public AbilityScore getCharisma() {
        return charisma;
    }

    public void setCharisma(AbilityScore charisma) {
        this.charisma = charisma;
    }
}
