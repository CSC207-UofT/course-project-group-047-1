package use_case;

import entity.GroceryItem;

import java.util.ArrayList;


/**
 * Interface for data access of Inventory.txt file
 */
public interface InventoryDataAccess {

    /**
     * @return Read Inventory.txt file and return an ArrayList of GroceryItem
     */
    ArrayList<GroceryItem> read();

    /**
     * @param items
     * update Inventory.txt according to changes in items
     */
    void update(ArrayList<GroceryItem> items);
}
