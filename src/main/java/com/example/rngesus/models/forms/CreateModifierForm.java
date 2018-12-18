package com.example.rngesus.models.forms;

import com.example.rngesus.models.Modifier;
import com.example.rngesus.models.ModifierType;
import com.example.rngesus.models.Trait;
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

    private Integer diceCount;

    private DieType dieType;

    private Integer fixedValue;

    private Integer durationInterval;

    private DurationType durationType;

    @Embedded
    private Modifier modifier;

    @Embedded
    private Trait trait;

    private Iterable<ModifierType> modifierTypes;

    private DieType[] dieTypes = DieType.values();

    private DurationType[] durationTypes = DurationType.values();



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

    public Integer getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(Integer diceCount) {
        this.diceCount = diceCount;
    }

    public DieType getDieType() {
        return dieType;
    }

    public void setDieType(DieType dieType) {
        this.dieType = dieType;
    }

    public Integer getFixedValue() {
        return fixedValue;
    }

    public void setFixedValue(Integer fixedValue) {
        this.fixedValue = fixedValue;
    }

    public Integer getDurationInterval() {
        return durationInterval;
    }

    public void setDurationInterval(Integer durationInterval) {
        this.durationInterval = durationInterval;
    }

    public DurationType getDurationType() {
        return durationType;
    }

    public void setDurationType(DurationType durationType) {
        this.durationType = durationType;
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
