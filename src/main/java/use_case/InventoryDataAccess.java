package use_case;

import entity.GroceryItem;

import java.util.ArrayList;

public interface InventoryDataAccess {

    ArrayList<GroceryItem> read();

    void update(ArrayList<GroceryItem> items);
}
