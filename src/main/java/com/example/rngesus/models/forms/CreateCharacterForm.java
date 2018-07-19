package com.example.rngesus.models.forms;

import com.example.rngesus.models.AbilityScore;
import com.example.rngesus.models.CharacterClass;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.Race;
import com.example.rngesus.models.enumerations.AbilityScoreType;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CreateCharacterForm {

    @NotNull
    private int characterId;

    @NotNull
    private int raceId;

    @NotNull
    private int classId;

    @NotNull
    private List<AbilityScore> abilityScores = new ArrayList<AbilityScore>();

    private PlayerCharacter playerCharacter;

    private Iterable<Race> races;

    private Iterable<CharacterClass> classes;

    private AbilityScoreType[] abilities = AbilityScoreType.values();

    public CreateCharacterForm() {
    }

    public CreateCharacterForm(PlayerCharacter playerCharacter, Iterable<Race> races ,Iterable<CharacterClass> classes) {
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

    public List<AbilityScore> getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(List<AbilityScore> abilityScores) {
        this.abilityScores = abilityScores;
    }

    public AbilityScoreType[] getAbilities() {
        return abilities;
    }

    public void setAbilities(AbilityScoreType[] abilities) {
        this.abilities = abilities;
    }
}
