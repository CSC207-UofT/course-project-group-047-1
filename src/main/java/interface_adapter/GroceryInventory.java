package interface_adapter;

import entity.GroceryItem;
import use_case.InventoryDataAccess;

import java.io.*;
import java.util.ArrayList;


/**
 * This class manage all items in store
 */
public class GroceryInventory {

    private InventoryDataAccess db;
    private ArrayList<GroceryItem> items = new ArrayList<>();


    /**
     * Constructor
     */
    public GroceryInventory(InventoryDataAccess db) {
        this.db = db;
        items = this.db.read();
    }


    //TODO migrate this method to OrderPresenter
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


    //TODO this method check if n is an id that exists
    public boolean exists() {return true;}


    /**
     * Reduces the quantity in stock of an item with id by n
     *
     * @param id: is the id of the item to be reduced
     * @param n:  is the quantity reduced of the item
     */
    public void reduce(int id, int n) {
        for (GroceryItem item : this.items) {
            if (item.getId() == id) {
                item.reduce(n);
            }
        }
        this.db.update(this.items);
    }


    /**
     * Increases the quantity in stock of an item with id by n
     *
     * @param id: is the id of the item to be increased
     * @param n:  is the quantity increased of the item
     */
    public void add(int id, int n) {
        for (GroceryItem item : this.items) {
            if (item.getId() == id) {
                item.add(n);
            }
        }
        this.db.update(this.items);
    }


    /**
     * Puts the given items back into the inventory
     *
     * @param list is a list of grocery items
     */
    public void putBack(ArrayList<GroceryItem> list) {
        for (GroceryItem item : list) {
            int id = item.getId();
            int q = item.getQuantity();
            this.add(id, q);
        }
    }


    /**
     * Creates a new GroceryItem with a given id and quantity from the inventory
     *
     * @param id: is the id of the item
     * @param q:  is the quantity in stock of the item
     */
    public GroceryItem createItem(int id, int q) {
        for (GroceryItem i : this.items) {
            if (i.getId() == id) {
                String name = i.getName();
                double price = i.getPrice();
                return new GroceryItem(id, name, price, q);
            }
        }
        return null;
    }


    /**
     * Returns the quantity in stock of a given item
     *
     * @param id: is the id of the item
     */
    public int getQuantity(int id) {
        for (GroceryItem i : this.items) {
            if (i.getId() == id) {
                return i.getQuantity();
            }
        }
        return 0;
    }
}
