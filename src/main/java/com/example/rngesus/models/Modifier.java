package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.DieType;
import com.example.rngesus.models.enumerations.DurationType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Modifier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name="type_id", nullable=false)
    private ModifierType type;

    @ManyToOne
    @JoinColumn(name="sub_type_id", nullable=false)
    private ModifierSubType subType;

    private Integer diceCount;

    private DieType dieType;

    private Integer fixedValue;

    private Integer durationInterval;

    private DurationType durationType;

    @ManyToMany
    @JoinTable(name="trait_modifiers")
    private List<Trait> traits = new ArrayList<>();



    public Modifier() {
    }

    public Modifier(ModifierType type, ModifierSubType subType) {
        this.type = type;
        this.subType = subType;
    }



    public int getId() {
        return id;
    }

    public ModifierType getType() {
        return type;
    }

    public void setType(ModifierType type) {
        this.type = type;
    }

    public ModifierSubType getSubType() {
        return subType;
    }

    public void setSubType(ModifierSubType subType) {
        this.subType = subType;
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

    public List<Trait> getTraits() {
        return traits;
    }

    public void addTrait(Trait trait) {
        this.traits.add(trait);
    }

    public void addTraits(List<Trait> traits) {
        this.traits.addAll(traits);
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }
}
