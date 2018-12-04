package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.ModifierType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private String name;

    @NotNull
    private ArrayList<ModifierType> modifierTypes;

    @NotNull
    @OneToMany
    @JoinColumn(name = "modifier_id")
    private List<Modifier> modifiers = new ArrayList<>();



    public ModifierSubType() {
    }

    public ModifierSubType(@NotNull String name, @NotNull ArrayList<ModifierType> modifierTypes, @NotNull List<Modifier> modifiers) {
        this.name = name;
        this.modifierTypes = modifierTypes;
        this.modifiers = modifiers;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModifierType> getModifierTypes() {
        return modifierTypes;
    }

    public void addModifierType(ModifierType modifierType) {
        this.modifierTypes.add(modifierType);
    }

    public void addModifierTypes(List<ModifierType> modifierTypes) {
        this.modifierTypes.addAll(modifierTypes);
    }

    public void setModifierTypes(ArrayList<ModifierType> modifierTypes) {
        this.modifierTypes = modifierTypes;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }
}
