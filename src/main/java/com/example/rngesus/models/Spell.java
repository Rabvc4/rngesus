package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min=3, max=30)
    private String name;

    @NotNull
    private Integer level;

    private DurationType castingTime;

    private DurationType spellDuration;

    private ArrayList<CastingComponent> castingComponents;

    private SchoolOfMagic schoolOfMagic;

    private ArrayList<SpellType> spellTypes;

    private Boolean concentration;

    private Boolean ritual;

    private AbilityScoreType save;

    private Boolean onSelf;

//    @ManyToMany(mappedBy = "spells")
//    private List<CharacterClass> characterClasses;



    public Spell() {
    }

    public Spell(@NotNull @Size(min = 3, max = 30) String name, @NotNull Integer level, DurationType castingTime, DurationType spellDuration, ArrayList<CastingComponent> castingComponents, SchoolOfMagic schoolOfMagic, ArrayList<SpellType> spellTypes, Boolean concentration, Boolean ritual, AbilityScoreType save, Boolean onSelf) {
        this.name = name;
        this.level = level;
        this.castingTime = castingTime;
        this.spellDuration = spellDuration;
        this.castingComponents = castingComponents;
        this.schoolOfMagic = schoolOfMagic;
        this.spellTypes = spellTypes;
        this.concentration = concentration;
        this.ritual = ritual;
        this.save = save;
        this.onSelf = onSelf;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public DurationType getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(DurationType castingTime) {
        this.castingTime = castingTime;
    }

    public DurationType getSpellDuration() {
        return spellDuration;
    }

    public void setSpellDuration(DurationType spellDuration) {
        this.spellDuration = spellDuration;
    }

    public ArrayList<CastingComponent> getCastingComponents() {
        return castingComponents;
    }

    public void setCastingComponents(ArrayList<CastingComponent> castingComponents) {
        this.castingComponents = castingComponents;
    }

    public void addCastingComponent(CastingComponent castingComponent) {
        this.castingComponents.add(castingComponent);
    }

    public void addCastingComponents(ArrayList<CastingComponent> castingComponents) {
        this.castingComponents.addAll(castingComponents);
    }

    public SchoolOfMagic getSchoolOfMagic() {
        return schoolOfMagic;
    }

    public void setSchoolOfMagic(SchoolOfMagic schoolOfMagic) {
        this.schoolOfMagic = schoolOfMagic;
    }

    public ArrayList<SpellType> getSpellTypes() {
        return spellTypes;
    }

    public void setSpellTypes(ArrayList<SpellType> spellTypes) {
        this.spellTypes = spellTypes;
    }

    public void addSpellType(SpellType spellType) {
        this.spellTypes.add(spellType);
    }

    public void addSpellTypes(ArrayList<SpellType> spellTypes) {
        this.spellTypes.addAll(spellTypes);
    }

    public Boolean getConcentration() {
        return concentration;
    }

    public void setConcentration(Boolean concentration) {
        this.concentration = concentration;
    }

    public Boolean getRitual() {
        return ritual;
    }

    public void setRitual(Boolean ritual) {
        this.ritual = ritual;
    }

    public AbilityScoreType getSave() {
        return save;
    }

    public void setSave(AbilityScoreType save) {
        this.save = save;
    }

    public Boolean getOnSelf() {
        return onSelf;
    }

    public void setOnSelf(Boolean onSelf) {
        this.onSelf = onSelf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spell)) return false;

        Spell spell = (Spell) o;

        if (getId() != spell.getId()) return false;
        if (!getName().equals(spell.getName())) return false;
        if (!getLevel().equals(spell.getLevel())) return false;
        if (getCastingTime() != spell.getCastingTime()) return false;
        if (getSpellDuration() != spell.getSpellDuration()) return false;
        if (!getCastingComponents().equals(spell.getCastingComponents())) return false;
        if (getSchoolOfMagic() != spell.getSchoolOfMagic()) return false;
        if (!getSpellTypes().equals(spell.getSpellTypes())) return false;
        if (!getConcentration().equals(spell.getConcentration())) return false;
        if (!getRitual().equals(spell.getRitual())) return false;
        if (getSave() != spell.getSave()) return false;
        return getOnSelf().equals(spell.getOnSelf());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getLevel().hashCode();
        result = 31 * result + getCastingTime().hashCode();
        result = 31 * result + getSpellDuration().hashCode();
        result = 31 * result + getCastingComponents().hashCode();
        result = 31 * result + getSchoolOfMagic().hashCode();
        result = 31 * result + getSpellTypes().hashCode();
        result = 31 * result + getConcentration().hashCode();
        result = 31 * result + getRitual().hashCode();
        result = 31 * result + getSave().hashCode();
        result = 31 * result + getOnSelf().hashCode();
        return result;
    }
}
