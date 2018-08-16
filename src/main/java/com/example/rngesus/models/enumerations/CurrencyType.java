package com.example.rngesus.models.enumerations;

public enum CurrencyType {

    cp ("Copper"),
    sp ("Silver"),
    ep ("Electrum"),
    gp ("Gold"),
    pp ("Platinum");

    private final String name;

    CurrencyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
