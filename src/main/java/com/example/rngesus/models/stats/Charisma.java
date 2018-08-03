package com.example.rngesus.models.stats;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Charisma {

    @Column(name = "charisma")
    private Integer value;

    @Column(name = "charisma_modifier")
    private Integer modifier;

    public Charisma() {
    }

    public Charisma(Integer value) {
        this.setValue(value);
    }

    public Charisma(Integer value, Integer modifier) {
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
        if (!(o instanceof Charisma)) return false;

        Charisma charisma = (Charisma) o;

        return getValue().equals(charisma.getValue());
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
