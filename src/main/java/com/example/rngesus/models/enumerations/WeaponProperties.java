package com.example.rngesus.models.enumerations;

public enum WeaponProperties {

    AMMUNITION ("Ammunition", "Simple Melee Weapons"),
    FINESSE ("Finesse", "Martial Melee Weapons"),
    LIGHT ("Light", "Exotic Melee Weapons"),
    LOADING ("Loading", "Simple Ranged Weapons"),
    RANGE ("Range", "Martial Ranged Weapons"),
    REACH ("Reach", "Martial Ranged Weapons"),
    SPECIAL ("Special", "Martial Ranged Weapons"),
    TWO_HANDED ("Two-Handed", "Martial Ranged Weapons"),
    VERSATILE ("Versatile", "Martial Ranged Weapons"),
    IMPROVISED ("Improvised", "Martial Ranged Weapons"),
    SILVER ("Silvered", "Exotic Ranged Weapons");

    private final String name;
    private final String description;

    WeaponProperties(String name, String description) {
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
