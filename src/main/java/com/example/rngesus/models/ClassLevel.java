package com.example.rngesus.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
public class ClassLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @ManyToOne
    private CharacterClass baseClass;

    @NotNull
    private Integer level;

    @NotNull
    private Integer proficiencyBonus;

    @NotNull
    private String features;

    private ArrayList<Integer> spells;



    public ClassLevel() {
    }

    public ClassLevel(CharacterClass baseClass, @NotNull Integer level, @NotNull Integer proficiencyBonus, @NotNull String features) {
        this.baseClass = baseClass;
        this.level = level;
        this.proficiencyBonus = proficiencyBonus;
        this.features = features;
    }



    public int getId() {
        return id;
    }

    public CharacterClass getBaseClass() {
        return baseClass;
    }

    public void setBaseClass(CharacterClass baseClass) {
        this.baseClass = baseClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(Integer proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public ArrayList<Integer> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Integer> spells) {
        this.spells = spells;
    }

}
