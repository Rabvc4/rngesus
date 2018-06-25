package com.example.rngesus.models.stats;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Wisdom {

    @NotNull
    @Max(value = 30,message = "The gods cannot exceed 30, so neither can you")
    @Min(value = 1,message = "Cannot be 0 or a negative number (Pretty sure you'd be dead)")
    private Integer wisdom;

    @NotNull
    private Integer wisdomModifier;

    public Integer getWisdom() {
        return wisdom;
    }

    public Integer getWisdomModifier() {
        return wisdomModifier;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
        double modifier = (double)(wisdom - 10) / 2;
        this.wisdomModifier = (int) Math.floor(modifier);
    }

}
