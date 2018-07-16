package com.example.rngesus.models;

public class AbilityScore {

    private Integer value;
    private int id;
    private static int nextId = 1;

    public AbilityScore() {
        id = nextId;
        nextId++;
    }

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

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

}
