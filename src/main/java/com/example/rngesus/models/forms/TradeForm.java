package com.example.rngesus.models.forms;

import com.example.rngesus.models.Item;
import com.example.rngesus.models.PlayerCharacter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class TradeForm {

    @NotNull
    private Integer characterId;

    @NotNull
    private Integer partnerId;

    @NotNull
    private ArrayList<Item> transaction;

    @NotNull
    private ArrayList<Item> trader1Items;

    @NotNull
    private ArrayList<Item> trader2Items;


    
    public TradeForm() {

    }

    public TradeForm(@NotNull PlayerCharacter character, @NotNull Integer partnerId, @NotNull ArrayList<Item> items) {

    }

}
