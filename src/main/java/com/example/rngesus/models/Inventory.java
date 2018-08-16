package com.example.rngesus.models;

import com.example.rngesus.models.enumerations.CurrencyType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Entity
public class Inventory {

//  Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    private HashMap<CurrencyType, Integer> currency;

    @ManyToMany
    private List<Item> items;

    private Integer weight;

    @OneToOne(mappedBy = "inventory")
    private PlayerCharacter playerCharacter;

//  Constructors
    public Inventory() {
    }



//  Getters and setters
    public long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
        this.weight += item.getWeight();
    }

    public void removeItem(Item item) {
        this.items.remove(item);
        this.weight -= item.getWeight();
    }

    public HashMap<CurrencyType, Integer> getCurrency() {
        return currency;
    }

    public void setCurrency(HashMap<CurrencyType, Integer> currency) {
        this.currency = currency;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
}
