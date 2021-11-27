package interface_adapter;

import entity.GroceryItem;
import use_case.InventoryDataAccess;

import java.util.ArrayList;

public class InventoryPresenter {

    InventoryDataAccess db;

    ArrayList<GroceryItem> items;

    public InventoryPresenter(InventoryDataAccess db) {
        this.db = db;
        this.items = db.read();
    }


    /**
     * @return a string representation of GroceryItems in the store
     */
    public String view() {

        StringBuilder string = new StringBuilder();

        for (GroceryItem item : this.items) {

            string.append(item.getId()).append(" ").append(item.getName()).append(" x ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice()).append("$ each\n");

        }

        return string.toString();

    }
}
