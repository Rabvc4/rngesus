package com.example.rngesus.models.trading;

import com.example.rngesus.models.Item;
import com.example.rngesus.models.PlayerCharacter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class TradeRecord {

    @NotNull
    private final Integer party1;

    private final Integer party2;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private final Date timeStamp = new Date();

    private HashMap<Integer, HashMap<Item, Integer>> trade;



    public TradeRecord(PlayerCharacter playerCharacter) {
        this.party1 = playerCharacter.getId();
        this.party2 = null;
    }

    public TradeRecord(Integer party1) {
        this.party1 = party1;
        this.party2 = null;
    }

    public TradeRecord(Integer party1, Integer party2) {
        this.party1 = party1;
        this.party2 = party2;
    }



    public Integer getParty1() {
        return party1;
    }

    public Integer getParty2() {
        return party2;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void offerItem(Integer characterId, Item item) {
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(item, 1);
        offerItem(characterId, items);
    }

    public void offerItem(Integer characterId, HashMap<Item, Integer> items) {

        if (!trade.containsKey(characterId)) {
            this.trade.put(characterId, items);
        } else {
            HashMap<Item, Integer> offering = getOffer(characterId);
            Iterator it = items.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                Item item = (Item) pair.getKey();
                Integer quantity = (Integer) pair.getValue();
                offering.put(item, offering.getOrDefault(item, 0) + quantity);


//                TODO - will this just add a new entry for each update?
                this.trade.put(characterId, offering);
            }
        }

    }

    public HashMap<Item, Integer> getOffer (Integer characterId) {
        return this.trade.get(characterId);
    }

    @Override
    public String toString() {
        return "Trade between " + party1 + " and " + party2 + " started: " + timeStamp;
    }
}
