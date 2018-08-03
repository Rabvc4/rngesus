package com.example.rngesus.models.stats;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Dexterity {

    @Column(name = "dexterity")
    private Integer value;

    @Column(name = "dexterity_modifier")
    private Integer modifier;

    public Dexterity() {
    }

    public Dexterity(Integer value) {
        this.setValue(value);
    }

    public Dexterity(Integer value, Integer modifier) {
        this.value = value;
        this.modifier = modifier;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
        double newModifier = (double)(value - 10) / 2;
        this.modifier = (int) Math.floor(newModifier);
    }

    public Integer getModifier() {
        return modifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dexterity)) return false;

        Dexterity dexterity = (Dexterity) o;

        return getValue().equals(dexterity.getValue());
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
