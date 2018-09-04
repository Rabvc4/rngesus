package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.ItemType;
import com.example.rngesus.models.enumerations.RarityType;
import javafx.beans.DefaultProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @NotNull
    @Size(min=3, max=30)
    private String name;

    @NotNull
    @Column(columnDefinition = "DOUBLE DEFAULT 0.0")
    private Double weight;

    private Double height;
    private Double width;
    private Double depth;

    @NotNull
    @Column(columnDefinition = "INTEGER(255) DEFAULT 0")
    private Integer value;

    @NotNull
    private ItemType type;

    @NotNull
    private RarityType rarity;

    @NotNull
    @Size(min = 3, message = "Description must be at least 3 characters long")
    private String description;

    @ManyToMany(mappedBy = "items")
    private List<Inventory> inventories;



    public Item() {
    }

    public Item(@NotNull @Size(min = 3, max = 30) String name, @NotNull ItemType type, @NotNull RarityType rarity, @NotNull String description) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        if (weight != null) {
            this.weight = weight;
        } else {
            this.weight = 0.0;
        }
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        if (value != null) {
            this.value = value;
        } else {
            this.value = 0;
        }
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public RarityType getRarity() {
        return rarity;
    }

    public void setRarity(RarityType rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

}
