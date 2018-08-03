package com.example.rngesus.models.stats;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Constitution {

    @Column(name = "constitution")
    private Integer value;

    @Column(name = "constitution_modifier")
    private Integer modifier;

    public Constitution() {
    }

    public Constitution(Integer value) {
        this.setValue(value);
    }

    public Constitution(Integer value, Integer modifier) {
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
        if (!(o instanceof Constitution)) return false;

        Constitution that = (Constitution) o;

        return getValue().equals(that.getValue());
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
