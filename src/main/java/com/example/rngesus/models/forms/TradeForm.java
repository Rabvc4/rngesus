package com.example.rngesus.models.forms;

import com.example.rngesus.models.Inventory;
import com.example.rngesus.models.Item;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class TradeForm {

    @NotNull
    private Inventory characterInventory;

    @NotNull
    private Inventory partnerInventory;

    @NotNull
    private String characterName;

    @NotNull
    private String partnerName;

    private ArrayList<Item> items = new ArrayList<>();
    private Integer total;



    public TradeForm() {

    }

    public TradeForm(@NotNull Inventory characterInventory, @NotNull Inventory partnerInventory, @NotNull String characterName, @NotNull String partnerName) {
        this.characterInventory = characterInventory;
        this.partnerInventory = partnerInventory;
        this.characterName = characterName;
        this.partnerName = partnerName;
    }

    public Inventory getCharacterInventory() {
        return characterInventory;
    }

    public void setCharacterInventory(Inventory characterInventory) {
        this.characterInventory = characterInventory;
    }

    public Inventory getPartnerInventory() {
        return partnerInventory;
    }

    public void setPartnerInventory(Inventory partnerInventory) {
        this.partnerInventory = partnerInventory;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
}
