package com.example.rngesus.models.forms;

import com.example.rngesus.models.Item;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class TradeForm {

    @NotNull
    private Integer characterId;

    @NotNull
    private Integer partnerId;

    @NotNull
    private ArrayList<Item> items;



    public TradeForm() {

    }

    public TradeForm(@NotNull Integer characterId, @NotNull Integer partnerId, @NotNull ArrayList<Item> items) {
        this.characterId = characterId;
        this.partnerId = partnerId;
        this.items = items;
    }



    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item items) {
        this.items.add(items);
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }
}
