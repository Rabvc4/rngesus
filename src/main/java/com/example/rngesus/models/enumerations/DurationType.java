package com.example.rngesus.models.enumerations;

public enum DurationType {

    REACTION ("Reaction"),
    BONUS_ACTION ("Bonus Action"),
    ACTION ("Action"),
    ONE_MINUTE ("1 Minute"),
    TEN_MINUTES ("10 Minutes"),
    ONE_HOUR ("1 Hour"),
    EIGHT_HOURS ("8 Hours"),
    ONE_DAY ("24 Hours"),
    SEVEN_DAYS ("7 Days"),
    TEN_DAYS ("10 Days"),
    THIRTY_DAYS ("30 Days"),
    INDEFINITE ("Until Stopped/Dispelled");

    private final String name;

    DurationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
