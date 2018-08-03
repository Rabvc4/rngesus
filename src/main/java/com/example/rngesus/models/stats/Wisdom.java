package com.example.rngesus.models.stats;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Wisdom {

    @Column(name = "wisdom")
    private Integer value;

    @Column(name = "wisdom_modifier")
    private Integer modifier;

    public Wisdom() {
    }

    public Wisdom(Integer value) {
        this.setValue(value);
    }

    public Wisdom(Integer value, Integer modifier) {
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
        if (!(o instanceof Wisdom)) return false;

        Wisdom wisdom = (Wisdom) o;

        return getValue().equals(wisdom.getValue());
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
