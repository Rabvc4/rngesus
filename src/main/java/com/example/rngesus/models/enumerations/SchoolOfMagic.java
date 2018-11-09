package com.example.rngesus.models.enumerations;

public enum SchoolOfMagic {

    ABJURATION ("Abjuration", "Blocking, banishing, protecting", "Abjurer"),
    CONJURATION ("Conjuration", "Producing things/creatures out of thin air", "Conjurer"),
    DIVINATION ("Divination", "Understanding the past, present and future", "Diviner"),
    ENCHANTMENT ("Enchantment", "Entrancing and beguiling people/creatures", "Enchanter"),
    EVOCATION ("Evocation", "Harnessing the power of the elements", "Evoker"),
    ILLUSION ("Illusion", "Deception and trickery", "Illusionist"),
    NECROMANCY ("Necromancy", "Dealing with life, death and undeath", "Necromancer"),
    TRANSMUTATION ("Transmutation", "Changing energy and matter", "Transmuter");

    private final String name;
    private final String description;
    private final String tradition;

    SchoolOfMagic(String name, String description, String abbreviation) {
        this.name = name;
        this.description = description;
        this.tradition = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTradition() {
        return tradition;
    }
}
