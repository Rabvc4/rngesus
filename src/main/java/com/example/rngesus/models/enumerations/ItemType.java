package com.example.rngesus.models.enumerations;

public enum ItemType {

    WEAPON ("Weapon"),
    ARMOR ("Armor"),
    TOOL ("Tool"),
    CURRENCY ("Currency"),
    TRADE_GOOD ("Trade Good"),
    UTILITY ("Utility");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
