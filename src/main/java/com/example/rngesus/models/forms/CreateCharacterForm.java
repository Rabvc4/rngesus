package com.example.rngesus.models.forms;

import com.example.rngesus.models.CharacterClass;
import com.example.rngesus.models.PlayerCharacter;
import com.example.rngesus.models.Race;

import javax.validation.constraints.NotNull;

public class CreateCharacterForm {

    @NotNull
    private int characterId;

    @NotNull
    private int classId;

    private PlayerCharacter playerCharacter;


    private Iterable<CharacterClass> classes;

    public CreateCharacterForm() {
    }

    public CreateCharacterForm(PlayerCharacter playerCharacter, Iterable<CharacterClass> classes) {
        this.playerCharacter = playerCharacter;
        this.classes = classes;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
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

    public Iterable<CharacterClass> getClasses() {
        return classes;
    }

}
