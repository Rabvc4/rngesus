package com.example.rngesus.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min=2, max=50)
    private String name;

    @NotNull
    @Size(min=1)
    private String size;

    @NotNull
    @Max(value = 50,message = "Quit being lazy, well made characters can move faster than a railgun. Why does your BASE speed need to be so high?")
    @Min(value = 5,message = "Houseflies have a walking speed of 5. Are you playing a game at the atomic level?")
    private Integer speed;

//    TODO: make trait object
    @NotNull
    @Length(min=1)
    private String traits;

    @NotNull
    @Size(min=2, max=100)
    private String languages;

    @OneToMany
    @JoinColumn(name = "race_id")
    private List<PlayerCharacter> playerCharacters = new ArrayList<>();

    public Race() { }

    public Race(String name, String size, Integer speed, String traits, String languages) {
        this.name = name;
        this.size = size;
        this.speed = speed;
        this.traits = traits;
        this.languages = languages;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getTraits() {
        return traits;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public List<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }
}
