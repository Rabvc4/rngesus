package com.example.rngesus.models.enumerations;

public enum RarityType {

    COMMON ("Common"),
    UNCOMMON ("Uncommon"),
    RARE ("Rare"),
    VERY_RARE ("Very Rare"),
    LEGENDARY ("Legendary"),
    ARTIFACT ("Artifact");

    private final String name;

    RarityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
