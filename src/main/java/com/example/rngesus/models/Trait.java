package com.example.rngesus.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trait {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min=3, max=30)
    private String name;

    @NotNull
    @Size(min = 3, max = 1000, message = "Description must be at least 3 characters long and no more than 1000")
    private String description;

    @NotNull
    @Size(min = 3, max = 128, message = "This should be easy after writing the description. Just give us the bullet points.")
    private String summary;

    private ArrayList<String> options;

    @ManyToMany(mappedBy = "traits")
    private List<Modifier> modifiers = new ArrayList<>();

    private ArrayList<String> spells;

    private ArrayList<String> actions;

    private ArrayList<String> creatures;

    private Boolean hideInBuilder = false;

    private Boolean hideInSheet = false;

    @ManyToMany
    private List<Race> races = new ArrayList<>();



    public Trait() {
    }

    public Trait(String name, String description, String summary, List<Race> races) {
        this.name = name;
        this.description = description;
        this.summary = summary;
        this.races = races;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void addOption(String s) {
        this.options.add(s);
    }

    public void addOptions(ArrayList<String> options) {
        this.options.addAll(options);
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public void addModifier(Modifier modifier) {
        this.modifiers.add(modifier);
    }

    public void addModifiers(List<Modifier> modifiers) {
        this.modifiers.addAll(modifiers);
    }

    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public ArrayList<String> getSpells() {
        return spells;
    }

    public void addSpell(String s) {
        this.spells.add(s);
    }

    public void addSpells(ArrayList<String> spells) {
        this.spells.addAll(spells);
    }

    public void setSpells(ArrayList<String> spells) {
        this.spells = spells;
    }

    public ArrayList<String> getActions() {
        return actions;
    }

    public void setActions(ArrayList<String> actions) {
        this.actions = actions;
    }

    public ArrayList<String> getCreatures() {
        return creatures;
    }

    public void addCreatures(String s) {
        this.creatures.add(s);
    }

    public void addAllCreatures(ArrayList<String> creatures) {
        this.creatures.addAll(creatures);
    }

    public void setCreatures(ArrayList<String> creatures) {
        this.creatures = creatures;
    }

    public Boolean getHideInBuilder() {
        return hideInBuilder;
    }

    public void setHideInBuilder(Boolean hideInBuilder) {
        this.hideInBuilder = hideInBuilder;
    }

    public Boolean getHideInSheet() {
        return hideInSheet;
    }

    public void setHideInSheet(Boolean hideInSheet) {
        this.hideInSheet = hideInSheet;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void addRace(Race race) {
        this.races.add(race);
    }

    public void addRaces(List<Race> races) {
        this.races.addAll(races);
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
