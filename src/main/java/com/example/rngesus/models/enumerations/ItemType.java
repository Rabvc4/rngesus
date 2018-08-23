package com.example.rngesus.models.enumerations;

public enum ItemType {

    ARMOR ("Armor", "Armor"),
    WEAPON ("Weapon", "Weapons"),
    GEAR ("Adventuring Gear", "Adventuring Gear"),
    TOOL ("Tool", "Tools"),
    CURRENCY ("Currency", "Currencies"),
    MOUNT ("Mount", "Mounts"),
    VEHICLE ("Vehicle", "Vehicles"),
    TRADE_GOOD ("Trade Good", "Trade Goods"),
    UTILITY ("Utility", "Utilities");

    private final String name;
    private final String plural;

    ItemType(String name, String plural) {
        this.name = name;
        this.plural = plural;
    }

    public String getName() {
        return name;
    }

    public String getPlural() {
        return plural;
    }
}
