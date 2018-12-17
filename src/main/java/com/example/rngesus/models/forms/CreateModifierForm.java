package com.example.rngesus.models.forms;

import com.example.rngesus.models.Modifier;
import com.example.rngesus.models.ModifierType;
import com.example.rngesus.models.Trait;
import com.example.rngesus.models.enumerations.AbilityScoreType;
import com.example.rngesus.models.enumerations.DieType;
import com.example.rngesus.models.enumerations.DurationType;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

public class CreateModifierForm {

    @NotNull
    private int modifierId;

    @NotNull
    private int traitId;

    @NotNull
    private int typeId;

    @NotNull
    private int subTypeId;

    @Embedded
    private Modifier modifier;

    @Embedded
    private Trait trait;

//    private Iterable<ModifierSubType> modifierSubTypes;

    private Iterable<ModifierType> modifierTypes;

    private AbilityScoreType[] abilities = AbilityScoreType.values();

    private DieType[] dieTypes = DieType.values();

    private DurationType[] durationTypes = DurationType.values();

    // TODO: 12/6/18 fixedValue and modifierSubType will need a solution



    public CreateModifierForm() {
    }

    public CreateModifierForm(Modifier modifier, Trait trait, Iterable<ModifierType> modifierTypes) {
        this.modifier = modifier;
        this.trait = trait;
        this.modifierTypes = modifierTypes;
    }


    public int getModifierId() {
        return modifierId;
    }

    public void setModifierId(int modifierId) {
        this.modifierId = modifierId;
    }

    public int getTraitId() {
        return traitId;
    }

    public void setTraitId(int traitId) {
        this.traitId = traitId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(int subTypeId) {
        this.subTypeId = subTypeId;
    }

    public Modifier getModifier() {
        return modifier;
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    public Trait getTrait() {
        return trait;
    }

    public void setTrait(Trait trait) {
        this.trait = trait;
    }

    public Iterable<ModifierType> getModifierTypes() {
        return modifierTypes;
    }

    public void setModifierTypes(Iterable<ModifierType> modifierTypes) {
        this.modifierTypes = modifierTypes;
    }

    public AbilityScoreType[] getAbilities() {
        return abilities;
    }

    public void setAbilities(AbilityScoreType[] abilities) {
        this.abilities = abilities;
    }

    public DieType[] getDieTypes() {
        return dieTypes;
    }

    public void setDieTypes(DieType[] dieTypes) {
        this.dieTypes = dieTypes;
    }

    public DurationType[] getDurationTypes() {
        return durationTypes;
    }

    public void setDurationTypes(DurationType[] durationTypes) {
        this.durationTypes = durationTypes;
    }
}
