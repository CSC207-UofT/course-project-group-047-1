package interface_adapter;

import entity.GroceryItem;

import java.util.ArrayList;

/**
 * A ShoppingCart temporarily stores grocery items for customers.
 */
public class ShoppingCart {


    private final ArrayList<GroceryItem> items;


    /**
     * Constructor
     */
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }


    /**
     * Adds an item to the shopping cart
     *
     * @param item: is the GroceryItem to be added
     */
    public void addItem(GroceryItem item) {
        for (GroceryItem i : items) {
            if (i.getId() == item.getId()) {
                i.add(item.getQuantity());
                return;
            }
        }
        items.add(item);
    }


    /**
     * Reduces the quantity in stock of item with id by n
     *
     * @param id: is the id of the item
     * @param n:  is the quantity in stock of the item
     */
    public void removeItem(int id, int n) {

        for (GroceryItem i : items) {
            if (i.getId() == id) {
                i.reduce(n);
            }
        }
    }


    /**
     * Returns the total price of the items in the shopping cart
     */
    public double getTotalPrice() {

        double total = 0;

        for (GroceryItem i : items) {
            total += i.getPrice() * i.getQuantity();
        }
        return total;
    }


    /**
     * Checks if this shopping cart is empty
     *
     * @return true is the shopping cart is empty, false otherwise
     */
    public boolean isEmpty() {

        if (this.items.size() == 0) {
            return true;
        }
        for (GroceryItem i : this.items) {
            if (i.getQuantity() != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * Returns a string representation of the items in the cart
     */
    public String view() {
        StringBuilder string;
        string = new StringBuilder();

        for (GroceryItem item : this.items) {

            string.append(item.getId()).append(" ").append(item.getName()).append(" x ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice()).append("$ each\n");
        }
        return string.toString();
    }


    /**
     * Returns the quantity in stock of items in cart
     */
    public int getQuantity() {
        int q = 0;
        for (GroceryItem i : items) {
            q += i.getQuantity();
        }
        return q;
    }


    /**
     * Returns a list of the items in the cart
     */
    public ArrayList<GroceryItem> getItems() {
        return this.items;
    }


    /**
     * @param id: is the id of a GroceryItem
     * @return the quantity in stock of the item with id in the shopping cart
     */
    public int getAmount(int id) {
        for (GroceryItem i : this.items) {
            if (i.getId() == id) {
                return i.getQuantity();
            }
        }
        return 0;
    }


}
