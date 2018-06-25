package com.example.rngesus.models.stats;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Charisma {

    @NotNull
    @Max(value = 30,message = "The gods cannot exceed 30, so neither can you")
    @Min(value = 1,message = "Cannot be 0 or a negative number (Pretty sure you'd be dead)")
    private Integer charisma;

    @NotNull
    private Integer charismaModifier;

    public Integer getCharisma() {
        return charisma;
    }

    public Integer getCharismaModifier() {
        return charismaModifier;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
        double modifier = (double)(charisma - 10) / 2;
        this.charismaModifier = (int) Math.floor(modifier);
    }

}
