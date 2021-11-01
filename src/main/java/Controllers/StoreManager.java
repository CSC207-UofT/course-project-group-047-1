// this class provide access to 'GroceryInventory' at Controller level

package Controllers;

import Entities.GroceryItem;
import Use_Case.GroceryInventory;

import java.util.ArrayList;

public class StoreManager {

    private final ArrayList<GroceryItem> items;

    public StoreManager() {
        GroceryInventory g = new GroceryInventory();
        this.items = g.getItems();
    }

    public String view() {

        StringBuilder string = new StringBuilder();

        for (GroceryItem item : this.items) {

            string.append(item.getName()).append(" x ").append(item.getQuantity()).append(", Price: ").append(item.getPrice()).append("$ each\n");

        }

        return string.toString();

    }
}
