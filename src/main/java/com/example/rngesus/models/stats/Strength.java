package com.example.rngesus.models.stats;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Strength {

    @NotNull
    @Max(value = 30,message = "The gods cannot exceed 30, so neither can you")
    @Min(value = 1,message = "Cannot be 0 or a negative number (Pretty sure you'd be dead)")
    private Integer strength;

    @NotNull
    private Integer strengthModifier;

    public Integer getStrength() {
        return strength;
    }

    public Integer getStrengthModifier() {
        return strengthModifier;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
        double modifier = (double)(strength - 10) / 2;
        this.strengthModifier = (int) Math.floor(modifier);
    }

}
