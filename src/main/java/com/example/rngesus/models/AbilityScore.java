package com.example.rngesus.models;

public class AbilityScore {


    private Integer value;
    private Integer modifier;

    public AbilityScore() { }

    public AbilityScore(Integer aValue) {
        this();
        value = aValue;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer aValue) {
        value = aValue;
    }

}
