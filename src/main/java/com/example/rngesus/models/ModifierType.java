package com.example.rngesus.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ModifierType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min=3, max=32)
    private String name;

    @NotNull
    @Size(min=3, max=280, message="Please give us a short description of the purpose of this modifier type, no more than 280 characters")
    private String description;

    @OneToMany
    private List<Modifier> modifiers = new ArrayList<>();

    @ManyToMany(mappedBy="types")
    @JsonManagedReference
    private List<ModifierSubType> subTypes;



    public ModifierType() {
    }

    public ModifierType(String name, String description) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addModifier(Modifier modifier) {
        this.modifiers.add(modifier);
    }

    public void addModifiers(List<Modifier> modifiers) {
        this.modifiers.addAll(modifiers);
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public List<ModifierSubType> getSubTypes() {
        return subTypes;
    }

    public void addModifierSubType(ModifierSubType modifierSubType) {
        this.subTypes.add(modifierSubType);
    }

    public void addModifierSubTypes(List<ModifierSubType> modifierSubTypes) {
        this.subTypes.addAll(modifierSubTypes);
    }

    public void setSubTypes(List<ModifierSubType> subTypes) {
        this.subTypes = subTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModifierType)) return false;

        ModifierType that = (ModifierType) o;

        if (getId() != that.getId()) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getDescription().equals(that.getDescription())) return false;
        if (getModifiers() != null ? !getModifiers().equals(that.getModifiers()) : that.getModifiers() != null)
            return false;
        return getSubTypes() != null ? getSubTypes().equals(that.getSubTypes()) : that.getSubTypes() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + (getModifiers() != null ? getModifiers().hashCode() : 0);
        result = 31 * result + (getSubTypes() != null ? getSubTypes().hashCode() : 0);
        return result;
    }
}
