package com.example.rngesus.models.enumerations;

public enum SpellType {

    BANISHMENT	("Banishment",	"You attempt to send one creature that you can see within range to another plane of existence. "),
    BUFF	("Buff",	"A positive status effect that affects mainly player or enemy statistics."),
    CHARM	("Charm",	"A charmed creature can’t Attack the charmer or target the charmer with harmful Abilities or magical effects. The charmer has advantage on any ability check to interact socially with the creature."),
    COMBAT	("Combat",	"Combat-oriented spells that often involve creating weapons and striking your opponent."),
    COMMUNICATION	("Communication",	"None provided"),
    COMPULSION	("Compulsion",	"None provided"),
    CONTROL	("Control",	"None provided"),
    CREATION	("Creation",	"None provided"),
    DAMAGE	("Damage",	"None provided"),
    DEBUFF	("Debuff",	"None provided"),
    DECEPTION	("Deception",	"None provided"),
    DETECTION	("Detection",	"None provided"),
    ENVIRONMENT	("Environment",	"None provided"),
    EXPLORATION	("Exploration",	"None provided"),
    FOREKNOWLEDGE	("Foreknowledge",	"None provided"),
    HEALING	("Healing",	"None provided"),
    MOVEMENT	("Movement",	"None provided"),
    NEGATION	("Negation",	"None provided"),
    SCRYING	("Scrying",	"None provided"),
    SHAPECHANGING	("Shapechanging",	"None provided"),
    SOCIAL	("Social",	"None provided"),
    SUMMONING	("Summoning",	"None provided"),
    TELEPORTATION	("Teleportation",	"None provided"),
    UTILITY	("Utility",	"None provided"),
    WARDING	("Warding",	"None provided");


    private final String name;
    private final String description;

    SpellType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
