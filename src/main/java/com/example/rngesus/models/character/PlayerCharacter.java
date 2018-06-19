package com.example.rngesus.models.character;

import com.example.rngesus.models.races.Race;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class PlayerCharacter {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, message = "You are not Clint Eastwood, your character must have a name")
    private String name;

    @ManyToOne
    private Race race;

//    private String characterClass;
//
//    private Integer health;
//    private ArrayList proficiencies;
//
//    private Integer level;
//    private ArrayList stats;
//
//    private ArrayList skills;
//    private ArrayList features;
//    private ArrayList abilities;
//
//    private ArrayList background;
//    private ArrayList inventory;
//
//    private Integer armor;
//    private String weapon;

    public PlayerCharacter() {  }

    public PlayerCharacter(String name, Race race) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerCharacter playerCharacter = (PlayerCharacter) o;

        return id == playerCharacter.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
