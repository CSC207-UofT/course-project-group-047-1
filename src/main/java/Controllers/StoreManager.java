// this class provide access to 'GroceryInventory' at Controller level

package Controllers;

import Entities.GroceryItem;
import Use_Case.GroceryInventory;

import java.util.ArrayList;

public class StoreManager {

    private final GroceryInventory g;
    private final ArrayList<GroceryItem> items;

    public StoreManager() {
        this.g = new GroceryInventory();
        this.items = g.getItems();
    }

    public String view() {

        StringBuilder string = new StringBuilder();

        for (GroceryItem item : this.items) {

            string.append(item.getId()).append(" ").append(item.getName()).append(" x ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice()).append("$ each\n");

        }

        return string.toString();

    }

    //updates the Inventory file to reflect reductions to quantity
    public void update() {this.g.UpdateInventory();}
}
