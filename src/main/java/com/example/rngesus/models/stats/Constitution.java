package com.example.rngesus.models.stats;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Constitution {

    @NotNull
    @Max(value = 30,message = "The gods cannot exceed 30, so neither can you")
    @Min(value = 1,message = "Cannot be 0 or a negative number (Pretty sure you'd be dead)")
    private Integer constitution;

    @NotNull
    private Integer constitutionModifier;

    public Integer getConstitution() {
        return constitution;
    }

    public Integer getConstitutionModifier() {
        return constitutionModifier;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
        double modifier = (double)(constitution - 10) / 2;
        this.constitutionModifier = (int) Math.floor(modifier);
    }

}
