package Controllers;

import Entities.GroceryItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A ShoppingCart temporarily stores GroceryItems for customers.
 */
public class ShoppingCart {

    private final ArrayList<GroceryItem> items;

    public ShoppingCart() {
    /*
     Creates a ShoppingCart.
     */
        this.items = new ArrayList<>();
    }


    public void addItem(GroceryItem item) {
        /*
        Adds a GroceryItem to the ShoppingCart.
         */
        for (GroceryItem i : items){
            if (i.getId() == item.getId()) {i.add(item.getQuantity());}
        }
        items.add(item);
    }


    public void removeItem(int id, int n){
        /*
        Removes this item if this item is in ShoppingCart.
         */
        for(GroceryItem i: items){
            if (i.getId() == id) {i.reduce(n);}
        }
    }


    public double getTotalPrice() {
        /*
        Gets the total price of the items in this ShoppingCart.
         */
        double total = 0;

        for (GroceryItem i: items) {
            total += i.getPrice()*i.getQuantity();
        }
        return total;
    }

    public boolean isEmpty() {
        /*
        Checks if this ShoppingCart is empty or not.
        Return true if is empty, return false if not.
         */
        if (this.items.size() == 0){
            return true;
        }
        for (GroceryItem i : this.items) {
            if (i.getQuantity() != 0) {return false;}
        }
        return true;
    }

    public String view(){
        /*
        Returns a string representation of the ShoppingCart, consisting of items in it.
         */

        StringBuilder string;
        string = new StringBuilder();

        for (GroceryItem item : this.items){

            string.append(item.getId()).append(" ").append(item.getName()).append(" x ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice()).append("$ each\n");
        }
        return string.toString();
    }

    public int getQuantity(){
        /*
        Gets the quantity of items in this ShoppingCart.
         */
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
