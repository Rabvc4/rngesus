package com.example.rngesus.models.forms;

import com.example.rngesus.models.CharacterClass;
import com.example.rngesus.models.Inventory;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.Race;
import com.example.rngesus.models.enumerations.AbilityScoreType;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

public class CreateCharacterForm {

    @NotNull
    private int characterId;

    @NotNull
    private int raceId;

    @NotNull
    private int classId;

    @NotNull
    private int strength;

    @NotNull
    private int dexterity;

    @NotNull
    private int constitution;

    @NotNull
    private int wisdom;

    @NotNull
    private int intelligence;

    @NotNull
    private int charisma;

    @Embedded
    private PlayerCharacter playerCharacter;

    private Iterable<Race> races;

    private Iterable<CharacterClass> classes;

    private AbilityScoreType[] abilities = AbilityScoreType.values();

    public CreateCharacterForm() {
    }

    public CreateCharacterForm(PlayerCharacter playerCharacter, Iterable<Race> races, Iterable<CharacterClass> classes) {
        this.playerCharacter = playerCharacter;
        this.races = races;
        this.classes = classes;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public Iterable<Race> getRaces() {
        return races;
    }

    public Iterable<CharacterClass> getClasses() {
        return classes;
    }

    public AbilityScoreType[] getAbilities() {
        return abilities;
    }

    public void setAbilities(AbilityScoreType[] abilities) {
        this.abilities = abilities;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
