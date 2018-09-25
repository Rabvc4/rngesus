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

    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "inventory_id"))
    @MapKeyJoinColumn(name = "item_id")
    @Column(name = "count")
    private Map<Item, Integer> items = new HashMap<>();

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


    public Map<Item, Integer> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.put(item, items.getOrDefault(item, 0) + 1);
        this.weight += item.getWeight();
    }

    public void addItem(Iterable<Item> items) {
        for (Item item : items) {
            addItem(item);
        }
//        this.weight = calculateWeight();
    }

    public void addItems(Item item, Integer integer) {

//        TODO - Delete test code
        System.out.println("Add Items Qty: " + integer);
        System.out.println("Add Items getOrDefault: " + items.getOrDefault(item,0));
        System.out.println("Add Items getOrDefault + Qty: " + items.getOrDefault(item,0) + integer);
//        TODO - Delete test code
        this.items.put(item, items.getOrDefault(item, 0) + integer);
        this.weight += (item.getWeight() * integer);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
        this.weight -= item.getWeight();
//        calculateWeight();
    }

    public void removeItem(Item item, Integer integer) {

        if (items.containsKey(item)) {

        }

        this.weight -= item.getWeight();


//        calculateWeight();
    }

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


    public void calculateWeight() {
        Double newWeight = 0.0;
        Iterator it = this.items.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry)it.next();
//            String name = (String) pair.getKey();
//            Item item = (Item) pair.getValue();
            Item item = (Item) pair.getKey();
            Integer quantity = (Integer) pair.getValue();

            newWeight += item.getWeight() * quantity;
//            it.remove();
        }

        this.weight = newWeight;
    }

}
