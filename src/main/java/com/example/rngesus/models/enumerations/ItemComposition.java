package com.example.rngesus.models.enumerations;

public enum ItemComposition {

    WOOD ("Wood"),
    CLOTH ("Cloth"),
    GLASS ("Glass"),
    STONE ("Stone"),
    STEEL ("Steel"),
    SILVER ("Silver"),
    GOLD ("Gold");

    private final String name;

    ItemComposition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
