package com.example.rngesus.models.forms;

import com.example.rngesus.models.forms.PlayerCharacter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
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
    @Length(min=1)
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

    public Race() {}

    public Race(@NotNull @Size(min = 2, max = 50) String name, @NotNull @Size(min = 1) String size, @NotNull @Length(min = 1) Integer speed, @NotNull @Length(min = 1) String traits, @NotNull @Size(min = 2, max = 100) String languages) {
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