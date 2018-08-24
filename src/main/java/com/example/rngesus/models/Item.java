package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.ItemType;
import com.example.rngesus.models.enumerations.RarityType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    private Integer weight;

    private Integer height;
    private Integer width;
    private Integer depth;

    private long value;

    @NotNull
    private ItemType type;

    @NotNull
    private RarityType rarity;

    @NotNull
    private String description;

//    @ManyToMany(mappedBy = "items")
//    private List<Inventory> inventories;



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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
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

}
