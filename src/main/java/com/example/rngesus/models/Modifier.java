package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Modifier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private ModifierType modifierType;

    @NotNull
    @ManyToOne
    private ModifierSubType modifierSubType;

    private AbilityScoreType abilityScore;

    private Integer diceCount;

    private DieType dieType;

    private Integer fixedValue;

    private String details;

    private Integer interval;

    private DurationType durationType;

    @ManyToMany
    private List<Trait> traits;



    public Modifier() {
    }

    public Modifier(@NotNull String name, @NotNull ModifierType modifierType, @NotNull ModifierSubType modifierSubType) {
        this.name = name;
        this.modifierType = modifierType;
        this.modifierSubType = modifierSubType;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModifierType getModifierType() {
        return modifierType;
    }

    public void setModifierType(ModifierType modifierType) {
        this.modifierType = modifierType;
    }

    public ModifierSubType getModifierSubType() {
        return modifierSubType;
    }

    public void setModifierSubType(ModifierSubType modifierSubType) {
        this.modifierSubType = modifierSubType;
    }

    public AbilityScoreType getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityScore(AbilityScoreType abilityScore) {
        this.abilityScore = abilityScore;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public DurationType getDurationType() {
        return durationType;
    }

    public void setDurationType(DurationType durationType) {
        this.durationType = durationType;
    }
}
