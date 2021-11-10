package Controllers;

import Entities.GroceryItem;
import java.util.ArrayList;

/**
 * A ShoppingCart temporarily stores GroceryItems for customers.
 */
public class ShoppingCart {


    private final ArrayList<GroceryItem> items;


    /**
     * constructor
     */
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }


    /**
     * add an item to this shopping cart
     * @param item: GroceryItem to be added
     */
    public void addItem(GroceryItem item) {
        for (GroceryItem i: items) {
            if (i.getId() == item.getId()) {
                i.add(item.getQuantity());
                return;
            }
        }
        items.add(item);
    }


    /**
     * reduce the quantity of item with id by n
     * @param id: int
     * @param n: int
     */
    public void removeItem(int id, int n){

        for(GroceryItem i: items){
            if (i.getId() == id) {i.reduce(n);}
        }
    }


    /**
     * @return: return total value of shopping cart
     */
    public double getTotalPrice() {

        double total = 0;

        for (GroceryItem i: items) {
            total += i.getPrice()*i.getQuantity();
        }
        return total;
    }


    /**
     * check if this shopping cart is empty
     * @return: boolean
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


    /**
     * @return: return a string representation of items in the cart
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


    /**
     * @return: return the quantity of items in cart
     */
    public int getQuantity(){
        int q = 0;
        for (GroceryItem i : items){
            q += i.getQuantity();
        }
        return q;
    }


    /**
     * @return: return a list of items in cart
     */
    public ArrayList<GroceryItem> getItems() {
        return this.items;
    }

}
