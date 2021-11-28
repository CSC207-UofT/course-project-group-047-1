package interface_adapter;

import entity.GroceryItem;
import use_case.InventoryDataAccess;
import use_case.Order;

import java.util.ArrayList;
import java.util.Iterator;

public class InventoryPresenter implements Iterable<GroceryItem>{

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
        this.items = db.read();

        StringBuilder string = new StringBuilder();

        for (GroceryItem item : this.items) {

            string.append(item.getId()).append(" ").append(item.getName()).append(" x ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice()).append("$ each\n");

        }

        return string.toString();

    }


    @Override
    public Iterator<GroceryItem> iterator() {
        return new InventoryIterator();
    }


    private class InventoryIterator implements Iterator<GroceryItem>{

        private int item = 0;

        @Override
        public boolean hasNext() {
            return this.item < db.read().size();
        }


        @Override
        public GroceryItem next() {
            this.item += 1;
            return db.read().get(item);
        }
    }

}
