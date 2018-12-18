package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.SizeType;
import org.hibernate.annotations.GenericGenerator;

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
    @Size(min=2, message = "That name is too short")
    @Size(max=32, message = "Names for races cannot exceed 32 characters")
    private String name;

    @NotNull
    private SizeType size;

    @NotNull
    @Size(min=10, message="Give them a brief introduction")
    @Size(max=128, message="Introductions cannot exceed 128 characters")
    private String introduction;

    @NotNull
    @Size(min=10, message="At least tell us something about this mysterious race of yours")
    @Size(max=512, message="Descriptions cannot exceed 512 characters")
    private String description;

    @ManyToMany(mappedBy="races")
    private List<Trait> traits;

    @OneToMany
    @JoinColumn(name="race_id")
    private List<PlayerCharacter> playerCharacters = new ArrayList<>();



    public Race() {
    }

    public Race(String name, SizeType size, String introduction, String description) {
        this.name = name;
        this.size = size;
        this.introduction = introduction;
        this.description = description;
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

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public void addTrait(Trait trait) {
        this.traits.add(trait);
    }

    public void addTraits(List<Trait> traits) {
        this.traits.addAll(traits);
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }

    public List<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }
}
