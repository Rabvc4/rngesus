package com.example.rngesus.models;

public class AbilityScore {

    private int id;
    private Integer value;
    private Integer modifier;
    private static int nextId = 1;

    public AbilityScore() {
        id = nextId;
        nextId++;
    }

    public AbilityScore(Integer aValue) {
        this();
        value = aValue;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
        double newModifier = (double)(value - 10) / 2;
        this.modifier = (int) Math.floor(newModifier);
    }

    public Integer getModifier() {
        return modifier;
    }

}
