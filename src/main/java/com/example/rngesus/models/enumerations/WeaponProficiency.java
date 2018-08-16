package com.example.rngesus.models.enumerations;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum WeaponProficiency {

    SIMPLE_MELEE ("Simple Melee Weapon", "Simple Melee Weapons", FALSE),
    MARTIAL_MELEE ("Martial Melee Weapon", "Martial Melee Weapons", FALSE),
    EXOTIC_MELEE ("Exotic Melee Weapon", "Exotic Melee Weapons", FALSE),
    SIMPLE_RANGED ("Simple Ranged Weapon", "Simple Ranged Weapons", TRUE),
    MARTIAL_RANGED ("Martial Ranged Weapon", "Martial Ranged Weapons", TRUE),
    EXOTIC_RANGED ("Exotic Ranged Weapon", "Exotic Ranged Weapons", TRUE);

    private final String name;
    private final String pluralName;
    private final Boolean isRanged;

    WeaponProficiency(String name, String pluralName, Boolean isRanged) {
        this.name = name;
        this.pluralName = pluralName;
        this.isRanged = isRanged;
    }

    public String getName() {
        return name;
    }

    public String getPluralName() {
        return pluralName;
    }

    public Boolean getRange() {
        return isRanged;
    }

}
