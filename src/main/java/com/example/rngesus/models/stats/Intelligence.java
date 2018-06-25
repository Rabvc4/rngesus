package com.example.rngesus.models.stats;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Intelligence {

    @NotNull
    @Max(value = 30,message = "The gods cannot exceed 30, so neither can you")
    @Min(value = 1,message = "Cannot be 0 or a negative number (Pretty sure you'd be dead)")
    private Integer intelligence;

    @NotNull
    private Integer intelligenceModifier;

    public Integer getIntelligence() {
        return intelligence;
    }

    public Integer getIntelligenceModifier() {
        return intelligenceModifier;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
        double modifier = (double)(intelligence - 10) / 2;
        this.intelligenceModifier = (int) Math.floor(modifier);
    }

}
