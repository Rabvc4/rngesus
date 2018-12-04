package com.example.rngesus.models.forms;

import com.example.rngesus.models.Race;
import com.example.rngesus.models.Trait;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateTraitForm {

    @NotNull
    private int traitId;

    @NotNull
    private int raceId;

    @Embedded
    private Race race;

    @Embedded
    private Trait trait;

    // TODO: 12/4/18 Add support for traits that change based upon character level
//    private int level;
//
//    private ExperienceLevel[] levels = ExperienceLevel.values();



    public CreateTraitForm() {
    }

    public CreateTraitForm(Trait trait, Race race) {
        this.trait = trait;
        this.race = race;
    }



    public int getTraitId() {
        return traitId;
    }

    public void setTraitId(int traitId) {
        this.traitId = traitId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Trait getTrait() {
        return trait;
    }

    public void setTrait(Trait trait) {
        this.trait = trait;
    }
}
