package com.example.rngesus.models.stats;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Dexterity {

    @NotNull
    @Max(value = 30,message = "The gods cannot exceed 30, so neither can you")
    @Min(value = 1,message = "Cannot be 0 or a negative number (Pretty sure you'd be dead)")
    private Integer dexterity;

    @NotNull
    private Integer dexterityModifier;

    public Integer getDexterity() {
        return dexterity;
    }

    public Integer getDexterityModifier() {
        return dexterityModifier;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
        double modifier = (double)(dexterity - 10) / 2;
        this.dexterityModifier = (int) Math.floor(modifier);
    }

}
