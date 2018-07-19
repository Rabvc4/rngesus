package com.example.rngesus.models.enumerations;

public enum AbilityScoreType {

    STR ("Strength"),
    DEX ("Dexterity"),
    CON ("Constitution"),
    INT ("Intelligence"),
    WIS ("Wisdom"),
    CHA ("Charisma");

    private final String name;

    AbilityScoreType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
