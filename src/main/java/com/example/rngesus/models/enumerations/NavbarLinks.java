package com.example.rngesus.models.enumerations;

public enum NavbarLinks {

    CHARACTERS ("Characters", "/character", "Checkout your characters"),
    CLASSES ("Classes", "/class", "Learn more about the different classes of the game"),
    RACES ("Races", "/race", "Learn more about the races of Dungeons & Dragons"),
    ITEMS ("Items", "/item", "Lookup information about the items of the games"),
    CREATE ("Create", "/create", "Make your dreams come true");

    private final String name;
    private final String url;
    private final String description;

    NavbarLinks(String name, String pluralName, String description) {
        this.name = name;
        this.url = pluralName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
