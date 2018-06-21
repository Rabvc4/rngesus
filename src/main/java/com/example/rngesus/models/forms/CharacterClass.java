package com.example.rngesus.models.forms;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Max(12)
    @Min(6)
    private Integer hitPoints;

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
    @Size(min=6, max=12)
    private String savingThrows;

    @NotNull
    @Size(min=3, max=100)
    private String skills;

    @OneToMany
    @JoinColumn(name = "characterClass_id")
    private List<PlayerCharacter> playerCharacters = new ArrayList<>();

    public CharacterClass() {  }

    public CharacterClass(String name, Integer hitPoints, String armorProficiency, String weaponProficiency, String tools, String savingThrows, String skills) {
        this.name = name;
        this.hitPoints = hitPoints;
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

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
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

    public String getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(String savingThrows) {
        this.savingThrows = savingThrows;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public List<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }

}
