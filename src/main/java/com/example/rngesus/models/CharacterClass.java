package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.AbilityScoreType;
import com.example.rngesus.models.enumerations.HitDiceType;
import com.example.rngesus.models.enumerations.SkillType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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
    @Size(min=3, max=100)
    private String armorProficiency;

    @NotNull
    @Size(min=3, max=100)
    private String weaponProficiency;

    @NotNull
    @Size(min=3, max=100)
    private String tools;

    @NotNull
    private ArrayList<AbilityScoreType> savingThrows;

    @NotNull
    private ArrayList<SkillType> skills;

    @ManyToMany(mappedBy = "classes")
    private List<PlayerCharacter> playerCharacters;

    public CharacterClass() { }

    public CharacterClass(String name, HitDiceType hitDice, String armorProficiency, String weaponProficiency, String tools, ArrayList<AbilityScoreType> savingThrows, ArrayList<SkillType> skills) {
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

    public String getArmorProficiency() {
        return armorProficiency;
    }

    public void setArmorProficiency(String armorProficiency) {
        this.armorProficiency = armorProficiency;
    }

    public String getWeaponProficiency() {
        return weaponProficiency;
    }

    public void setWeaponProficiency(String weaponProficiency) {
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

    public List<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }

}
