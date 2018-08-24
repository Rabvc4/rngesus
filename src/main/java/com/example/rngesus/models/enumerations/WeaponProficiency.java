package com.example.rngesus.models.enumerations;

public enum WeaponProficiency {

    SIMPLE_MELEE ("Simple Melee Weapon", "Simple Melee Weapons"),
    MARTIAL_MELEE ("Martial Melee Weapon", "Martial Melee Weapons"),
    EXOTIC_MELEE ("Exotic Melee Weapon", "Exotic Melee Weapons"),
    SIMPLE_RANGED ("Simple Ranged Weapon", "Simple Ranged Weapons"),
    MARTIAL_RANGED ("Martial Ranged Weapon", "Martial Ranged Weapons"),
    EXOTIC_RANGED ("Exotic Ranged Weapon", "Exotic Ranged Weapons");

    private final String name;
    private final String pluralName;

    WeaponProficiency(String name, String pluralName) {
        this.name = name;
        this.pluralName = pluralName;
    }

    public String getName() {
        return name;
    }

    public String getPluralName() {
        return pluralName;
    }
}
