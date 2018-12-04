package com.example.rngesus.models.enumerations;

public enum ModifierType {

    BONUS	("Bonus"),
    DAMAGE	("Damage"),
    ADVANTAGE	("Advantage"),
    DISADVANTAGE	("Disadvantage"),
    RESISTANCE	("Resistance"),
    IMMUNITY	("Immunity"),
    VULNERABILITY	("Vulnerability"),
    SENSE	("Sense"),
    SET	("Set"),
    PROFICIENCY	("Proficiency"),
    LANGUAGE	("Language"),
    EXPERTISE	("Expertise"),
    HALF_PROFICIENCY	("Half Proficiency"),
    FEAT	("Feat"),
    CARRYING_CAPACITY	("Carrying Capacity"),
    NATURAL_WEAPON	("Natural Weapon"),
    STEALTH_DISADVANTAGE	("Stealth Disadvantage"),
    SPEED_REDUCTION	("Speed Reduction"),
    MELEE_WEAPON_ATTACK	("Melee Weapon Attack"),
    RANGED_WEAPON_ATTACK	("Ranged Weapon Attack"),
    WEAPON_PROPERTY	("Weapon Property"),
    HALF_PROFICIENCY_ROUND_UP	("Half Proficiency Round Up"),
    FAVORED_ENEMY	("Favored Enemy"),
    IGNORE	("Ignore"),
    ELDRITCH_BLAST	("Eldritch Blast"),
    REPLACE_DAMAGE_TYPE	("Replace Damage Type"),
    TWICE_PROFICIENCY	("Twice Proficiency"),
    PROTECTION	("Protection"),
    STACKING_BONUS	("Stacking Bonus");

    private final String name;

    ModifierType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
