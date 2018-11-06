package com.example.rngesus.models.enumerations;

public enum WeaponProficiency {

    SIMPLE_WEAPON ("Simple Weapon", "Simple Weapons"),
    MARTIAL_WEAPON ("Martial Weapon", "Martial Weapons"),
    EXOTIC_WEAPON ("Exotic Weapon", "Exotic Weapons");

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
