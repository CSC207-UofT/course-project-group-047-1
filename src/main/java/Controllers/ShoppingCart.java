package Controllers;

import Entities.GroceryItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A ShoppingCart temporarily stores GroceryItems for customers.
 */
public class ShoppingCart {

    private final ArrayList<GroceryItem> items;

    /*
     Creates a ShoppingCart.
     */
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }


    /*
    Adds a GroceryItem to the ShoppingCart.
    */
    public void addItem(GroceryItem item) {

        for (GroceryItem i : items){
            if (i.getId() == item.getId()) {i.add(item.getQuantity());}
        }
        items.add(item);
    }


    /*
    Removes this item if this item is in ShoppingCart.
    */
    public void removeItem(int id, int n){

        for(GroceryItem i: items){
            if (i.getId() == id) {i.reduce(n);}
        }
    }

    /*
    Gets the total price of the items in this ShoppingCart.
    */
    public double getTotalPrice() {

        double total = 0;

        for (GroceryItem i: items) {
            total += i.getPrice()*i.getQuantity();
        }
        return total;
    }

    /*
    Checks if this ShoppingCart is empty or not.
    Return true if is empty, return false if not.
    */
    public boolean isEmpty() {

        if (this.items.size() == 0){
            return true;
        }
        for (GroceryItem i : this.items) {
            if (i.getQuantity() != 0) {return false;}
        }
        return true;
    }

    /*
    Returns a string representation of the ShoppingCart, consisting of items in it.
    */
    public String view(){
        StringBuilder string;
        string = new StringBuilder();

        for (GroceryItem item : this.items){

            string.append(item.getId()).append(" ").append(item.getName()).append(" x ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice()).append("$ each\n");
        }
        return string.toString();
    }

    /*
     Gets the quantity of items in this ShoppingCart.
     */
    public int getQuantity(){
        int q = 0;
        for (GroceryItem i : items){
            q += i.getQuantity();
        }
        return q;
    }

    public ArrayList<GroceryItem> getItems() {
        return this.items;
    }

}
