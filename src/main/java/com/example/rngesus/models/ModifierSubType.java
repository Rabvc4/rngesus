package com.example.rngesus.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ModifierSubType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min=2, message = "That name is too short")
    @Size(max=32, message = "Subtype names cannot be longer than 32 characters")
    private String name;

    @NotNull
    @Size(min=3, message="Please give us a short description of the purpose of this subtype")
    @Size(max=512, message="Descriptions cannot exceed 512 characters")
    private String description;

    @OneToMany
    private List<Modifier> modifiers = new ArrayList<>();

    @Size(min=1, message = "You must select at least one type for your subtype")
    @ManyToMany
    @JoinTable(name = "type_subtypes")
    @JsonBackReference
    private List<ModifierType> types = new ArrayList<>();



    public ModifierSubType() {
    }

    public ModifierSubType(String name, String description, List<ModifierType> types) {
        this.name = name;
        this.description = description;
        this.types = types;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public List<ModifierType> getTypes() {
        return types;
    }

    public void setTypes(List<ModifierType> types) {
        this.types = types;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModifierSubType)) return false;

        ModifierSubType that = (ModifierSubType) o;

        if (getId() != that.getId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getDescription() != null ? getDescription().equals(that.getDescription()) : that.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
