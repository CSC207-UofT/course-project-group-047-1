package use_case;

import entities.GroceryItem;

import java.util.ArrayList;

public interface InventoryDataAccess {

    ArrayList<GroceryItem> read();

    void update(ArrayList<GroceryItem> items);
}
