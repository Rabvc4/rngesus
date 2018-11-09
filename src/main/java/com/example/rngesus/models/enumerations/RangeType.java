package com.example.rngesus.models.enumerations;

public enum RangeType {

    SELF	("Self",	"A spell that is cast upon the caster."),
    TOUCH	("Touch",	"A spell that requires the caster to ‘touch’ the target. Can include the caster."),
    RANGED	("Ranged",	"The distance of a ranged spell typically varies with caster level."),
    SIGHT	("Sight",	"Caster must have a clear line-of-sight to the intended target location."),
    UNLIMITED	("Unlimited",	"Anywhere on the same plane of existence.");

    private final String name;
    private final String description;

    RangeType(String name, String description) {
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
