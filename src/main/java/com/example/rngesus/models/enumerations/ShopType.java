package com.example.rngesus.models.enumerations;

public enum ShopType {

    PAWNSHOP ("Pawnshop"),
    HERBS_INCENSE ("Herbs/Incense"),
    FRUITS_VEGETABLES ("Fruits/Vegetables"),
    DRIED_MEATS ("Dried Meats"),
    POTTERY ("Pottery"),
    UNDERTAKER ("Undertaker"),
    BOOKS ("Books"),
    MONEYLENDER ("Moneylender"),
    WEAPONS_ARMOR ("Weapons/Armor"),
    CHANDLER ("Chandler"),
    SMITHY ("Smithy"),
    CARPENTER ("Carpenter"),
    WEAVER ("Weaver"),
    JEWELER ("Jeweler"),
    BAKER ("Baker"),
    MAPMAKER ("Mapmaker"),
    TAILOR ("Tailor"),
    ROPEMAKER ("Ropemaker"),
    MASON ("Mason"),
    SCRIBE ("Scribe");

    private final String name;

    ShopType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
