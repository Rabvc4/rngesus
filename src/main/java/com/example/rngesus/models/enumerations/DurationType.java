package com.example.rngesus.models.enumerations;

public enum DurationType {

    REACTION ("Reaction"),
    BONUS_ACTION ("Bonus Action"),
    ACTION ("Action"),
    MINUTE ("Minute"),
    HOUR ("Hour"),
    DAY ("Day"),
    INDEFINITE ("Until Stopped/Dispelled");

    private final String name;

    DurationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
