package com.example.rngesus.models.enumerations;

public enum DamageType {

    SLASHING ("Slashing", "Cut"),
    BLUDGEONING ("Bludgeoning", "Smash"),
    PIERCING ("Piercing", "Pierce"),
    FIRE ("Fire", "Burn"),
    COLD ("Cold", "Freeze"),
    POISON ("Poison", "Toxin"),
    ACID ("Acid", "Corrosion"),
    PSYCHIC ("Psychic", "Mental Durability"),
    NECROTIC ("Necrotic", "Decay"),
    RADIANT ("Radiant", "Holy/Blinding"),
    LIGHTNING ("Lightning", "Electrical"),
    THUNDER ("Thunder", "Concussive"),
    FORCE ("Force", "Force");

    private final String name;
    private final String description;

    DamageType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
