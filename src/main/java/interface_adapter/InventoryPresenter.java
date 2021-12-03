package interface_adapter;

import entity.GroceryItem;
import use_case.InventoryDataAccess;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class provides a string presentation of the grocery inventory
 */
public class InventoryPresenter implements Iterable<GroceryItem> {

    InventoryDataAccess db;

    ArrayList<GroceryItem> items;

    /**
     * Constructor
     */
    public InventoryPresenter(InventoryDataAccess db) {
        this.db = db;
        this.items = db.read();
    }


    /**
     * Returns a string representation of the grocery inventory in the store
     */
    public String view() {
        this.items = db.read();
        Iterator<GroceryItem> itr = items.iterator();

        StringBuilder string = new StringBuilder();

        while (itr.hasNext()) {
            GroceryItem item = itr.next();
            string.append(item.getId()).append(" ").append(item.getName()).append(" x ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice()).append("$ each\n");
        }

        return string.toString();

    }


    /**
     * Returns an iterator that iterates through all grocery items in the store
     */
    @Override
    public Iterator<GroceryItem> iterator() {
        return new InventoryIterator();
    }


    /**
     * The iterator class for GroceryItem
     */
    private class InventoryIterator implements Iterator<GroceryItem> {

        private int item = 0;


        /**
         * Check if the iterator has a next element
         *
         * @return true if the iterator has a next element, false if otherwise
         */
        @Override
        public boolean hasNext() {
            return this.item < db.read().size();
        }


        /**
         * Returns the next grocery item in the list
         */
        @Override
        public GroceryItem next() {
            int curr_item = this.item;
            this.item += 1;
            return db.read().get(curr_item);
        }
    }

}
