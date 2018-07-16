package com.example.rngesus.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AbilityScore {

    private int id;
    private static int nextId = 1;

    @NotNull
    @Max(value = 30,message = "The gods cannot exceed 30 so neither can you")
    @Min(value = 1,message = "Cannot be 0 or a negative number (Pretty sure you'd be dead)")
    private Integer value;

    @NotNull
    private Integer modifier;

    public AbilityScore() {
        id = nextId;
        nextId++;
    }

    public AbilityScore(Integer value) {
        setValue(value);
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
