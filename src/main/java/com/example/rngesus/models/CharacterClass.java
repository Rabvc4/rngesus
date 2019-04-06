package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class CharacterClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min=2, max=50)
    private String name;

    @NotNull
    private HitDiceType hitDice;

    @NotNull
    private ArrayList<ArmorProficiency> armorProficiency;

    @NotNull
    private ArrayList<WeaponProficiency> weaponProficiency;

    @NotNull
    @Size(min=3, max=100)
    private String tools;

    @NotNull
    private ArrayList<AbilityScoreType> savingThrows;

    @NotNull
    @Column(columnDefinition = "BLOB")
    private ArrayList<SkillType> skills;

    @OneToMany(mappedBy="baseClass")
    @MapKey(name="level")
    private Map<Integer, ClassLevel> classLevels;

    @ManyToMany(mappedBy = "classes")
    private List<PlayerCharacter> playerCharacters;



    public CharacterClass() { }

    public CharacterClass(String name, HitDiceType hitDice, ArrayList<ArmorProficiency> armorProficiency, ArrayList<WeaponProficiency> weaponProficiency, String tools, ArrayList<AbilityScoreType> savingThrows, ArrayList<SkillType> skills) {
        this.name = name;
        this.hitDice = hitDice;
        this.armorProficiency = armorProficiency;
        this.weaponProficiency = weaponProficiency;
        this.tools = tools;
        this.savingThrows = savingThrows;
        this.skills = skills;
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

    public ArrayList<ArmorProficiency> getArmorProficiency() {
        return armorProficiency;
    }

    public void setArmorProficiency(ArrayList<ArmorProficiency> armorProficiency) {
        this.armorProficiency = armorProficiency;
    }

    public ArrayList<WeaponProficiency> getWeaponProficiency() {
        return weaponProficiency;
    }

    public void setWeaponProficiency(ArrayList<WeaponProficiency> weaponProficiency) {
        this.weaponProficiency = weaponProficiency;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public ArrayList<AbilityScoreType> getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(ArrayList<AbilityScoreType> savingThrows) {
        this.savingThrows = savingThrows;
    }

    public ArrayList<SkillType> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<SkillType> skills) {
        this.skills = skills;
    }

    public void addSkill(SkillType skill) {
        this.skills.add(skill);
    }

    public void addSkills(ArrayList<SkillType> skills) {
        this.skills.addAll(skills);
    }

    public HitDiceType getHitDice() {
        return hitDice;
    }

    public void setHitDice(HitDiceType hitDice) {
        this.hitDice = hitDice;
    }

    public Map<Integer, ClassLevel> getClassLevels() {
        return classLevels;
    }

    public void setClassLevels(Map<Integer, ClassLevel> classLevels) {
        this.classLevels = classLevels;
    }

    public void addClassLevel(ClassLevel classLevel) {
        this.classLevels.put(classLevel.getLevel(),classLevel);
    }

    public void addClassLevels(Map<Integer, ClassLevel> classLevels) {
        this.classLevels.putAll(classLevels);
    }

    public List<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        CharacterClass characterClass = (CharacterClass) o;

        if (getId() != characterClass.getId()) return false;
        return getName().equals(characterClass.getName());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        return result;
    }
}
