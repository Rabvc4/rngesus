package com.example.rngesus.models.stats;

import javax.persistence.Embeddable;

@Embeddable
public class AbilityScores {

    private Strength strength;
    private Dexterity dexterity;
    private Constitution constitution;
    private Wisdom wisdom;
    private Intelligence intelligence;
    private Charisma charisma;

    public AbilityScores() {
    }

    public AbilityScores(Strength strength, Dexterity dexterity, Constitution constitution, Wisdom wisdom, Intelligence intelligence, Charisma charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public Strength getStrength() {
        return strength;
    }

    public void setStrength(Integer integer) {
        this.setStrength(integer);
    }

    public void setStrength(Strength strength) {
        this.strength = strength;
    }

    public Dexterity getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer integer) {
        this.setDexterity(integer);
    }

    public void setDexterity(Dexterity dexterity) {
        this.dexterity = dexterity;
    }

    public Constitution getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer integer) {
        this.setConstitution(integer);
    }

    public void setConstitution(Constitution constitution) {
        this.constitution = constitution;
    }

    public Wisdom getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer integer) {
        this.setWisdom(integer);
    }

    public void setWisdom(Wisdom wisdom) {
        this.wisdom = wisdom;
    }

    public Intelligence getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer integer) {
        this.setIntelligence(integer);
    }

    public void setIntelligence(Intelligence intelligence) {
        this.intelligence = intelligence;
    }

    public Charisma getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer integer) {
        this.setCharisma(integer);
    }

    public void setCharisma(Charisma charisma) {
        this.charisma = charisma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbilityScores)) return false;

        AbilityScores that = (AbilityScores) o;

        if (!getStrength().equals(that.getStrength())) return false;
        if (!getDexterity().equals(that.getDexterity())) return false;
        if (!getConstitution().equals(that.getConstitution())) return false;
        if (!getWisdom().equals(that.getWisdom())) return false;
        if (!getIntelligence().equals(that.getIntelligence())) return false;
        return getCharisma().equals(that.getCharisma());
    }

    @Override
    public int hashCode() {
        int result = getStrength().hashCode();
        result = 31 * result + getDexterity().hashCode();
        result = 31 * result + getConstitution().hashCode();
        result = 31 * result + getWisdom().hashCode();
        result = 31 * result + getIntelligence().hashCode();
        result = 31 * result + getCharisma().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Strength: " + strength +
                "\nDexterity: " + dexterity +
                "\nConstitution: " + constitution +
                "\nWisdom: " + wisdom +
                "\nIntelligence: " + intelligence +
                "\nCharisma: " + charisma;
    }
}
