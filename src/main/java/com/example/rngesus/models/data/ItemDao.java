package com.example.rngesus.models.data;

import com.example.rngesus.models.Inventory;
import com.example.rngesus.models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ItemDao extends CrudRepository<Item, Integer> {

    List<Item> findByName(String name);

//    @Query(value = "SELECT * FROM item INNER JOIN inventory_items ON inventory_items.item_id=item.id where item.type = 4 and inventory_items.inventory_id = :inventoryId", nativeQuery = true)
//    List<Item> getCurrency(@Param("inventoryId") int inventoryId);

//    @Query("SELECT * FROM item INNER JOIN inventory_items ON inventory_items.item_id=item.id where item.type != 4 and inventory_items.inventory_id =:inventoryId")
//    Iterable<Inventory> getNonCurrency(@Param("inventoryId") int inventoryId);

}
