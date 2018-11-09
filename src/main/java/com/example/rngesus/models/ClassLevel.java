package com.example.rngesus.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ClassLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    private User user;

    @ManyToOne
    @JoinColumn(name="base_class_id")
    public CharacterClass baseClass;

    @NotNull
    private Integer level;

    @NotNull
    private Integer proficiencyBonus;

    @NotNull
    private String features;

//    @ElementCollection
//    @CollectionTable(joinColumns = @JoinColumn(name = "inventory_id"))
//    @MapKeyJoinColumn(name = "item_id")
//    @Column(name = "count")
//    private Map<Spell, Integer> spells = new HashMap<>();



    public ClassLevel() {
    }

    public ClassLevel(CharacterClass baseClass, @NotNull Integer level, @NotNull Integer proficiencyBonus, @NotNull String features) {
        this.baseClass = baseClass;
        this.level = level;
        this.proficiencyBonus = proficiencyBonus;
        this.features = features;
    }



    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CharacterClass getBaseClass() {
        return baseClass;
    }

    public void setBaseClass(CharacterClass baseClass) {
        this.baseClass = baseClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(Integer proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

//    public Map<Spell, Integer> getSpells() {
//        return spells;
//    }
//
//    public void addSpell(Spell spell) {
//        this.spells.put(spell, spells.getOrDefault(spell, 0) + 1);
//    }
//
//    public void addSpell(Iterable<Spell> spells) {
//        for (Spell spell : spells) {
//            addSpell(spell);
//        }
//    }
//
//    public boolean removeSpell(Spell spell) {
//        if (spells.containsKey(spell)) {
//            if (spells.get(spell) >= 1) {
//                spells.remove(spell, 1);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean removeSpells(Spell spell, Integer count) {
//
//        if (spells.containsKey(spell)) {
//            if (spells.get(spell) >= count) {
//                spells.remove(spell, count);
//                return true;
//            }
//        }
//        return false;
//    }

}
