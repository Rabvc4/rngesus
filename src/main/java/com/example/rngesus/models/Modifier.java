package com.example.rngesus.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Modifier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min=3, max=30)
    private String name;

    @NotNull
    @Size(min = 3, max = 128, message = "This should be easy after writing the description. Just give us the bullet points.")
    private String summary;

    @NotNull
    @Size(min = 3, max = 1000, message = "Description must be at least 3 characters long and no more than 1000")
    private String description;

    @ManyToMany
    @JoinTable(name="trait_modifiers")
    private List<Trait> traits = new ArrayList<>();



    public Modifier() {
    }

    public Modifier(@NotNull @Size(min = 3, max = 30) String name, @NotNull @Size(min = 3, max = 128, message = "This should be easy after writing the description. Just give us the bullet points.") String summary, @NotNull @Size(min = 3, max = 1000, message = "Description must be at least 3 characters long and no more than 1000") String description) {
        this.name = name;
        this.summary = summary;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
}
