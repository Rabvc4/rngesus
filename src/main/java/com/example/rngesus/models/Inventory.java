package com.example.rngesus.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

//    private HashMap<CurrencyType, Integer> currency = new HashMap<>();

//    @ManyToMany
//    private List<Item> items = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @MapKey(name = "name")
    private Map<String, Item> items = new HashMap<>();

    @NotNull
    @Column(columnDefinition = "DOUBLE DEFAULT 0.0")
    private Double weight = 0.0;

    @OneToOne(mappedBy = "inventory", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private PlayerCharacter playerCharacter;



    public Inventory() {
    }

    public Inventory(Iterable<Item> items) {
        this.addItem(items);
    }



    public int getId() {
        return id;
    }


    public Map<String, Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.put(item.getName(), item);
        this.weight += item.getWeight();
    }

    public void addItem(Iterable<Item> items) {
        for (Item item : items) {
            addItem(item);
        }
//        this.weight = calculateWeight(this.items);
    }

    public void removeItem(Item item) {
        this.items.remove(item.getName(), item);
        this.weight -= item.getWeight();
//        this.weight = calculateWeight(items);
    }


//    public HashMap<Item, Integer> getItems() {
//        return items;
//    }
//
//    public void addItem(Item item) {
//        this.items.put(item, items.getOrDefault(item, 1));
////        this.weight += item.getWeight();
//        this.weight = calculateWeight(items);
//    }
//
//    public void addItem(Item item, Integer x) {
//        this.items.put(item, items.getOrDefault(item, 0) + x);
////        this.weight += item.getWeight();
//        this.weight = calculateWeight(items);
//    }
//
//    public void removeItem(Item item) {
//        this.items.remove(item);
////        this.weight -= item.getWeight();
//        this.weight = calculateWeight(items);
//    }
//
//    public void removeItem(Item item, Integer x) {
//        this.items.put(item, items.getOrDefault(item, 0) + x);
//        this.weight = calculateWeight(items);
//    }


//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }

//    public HashMap<CurrencyType, Integer> getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(HashMap<CurrencyType, Integer> currency) {
//        this.currency = currency;
//    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }


    public Double calculateWeight(Map<String, Item> mp) {
        Double newWeight = 0.0;
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry)it.next();
            String name = (String) pair.getKey();
            Item item = (Item) pair.getValue();

            newWeight += item.getWeight();
//            it.remove();
        }

        return newWeight;
    }

}
