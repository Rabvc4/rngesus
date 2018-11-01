package com.example.rngesus.models.enumerations;

public enum ArmorProficiency {

    LIGHT_ARMOR ("Light Armor"),
    MEDIUM_ARMOR ("Medium Armor"),
    HEAVY_ARMOR ("Heavy Armor"),
    SHIELD ("Shield");

    private final String name;

    ArmorProficiency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
