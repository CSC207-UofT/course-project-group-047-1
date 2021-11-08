package Controllers;

import Entities.GroceryItem;

import java.util.HashMap;


public class ShoppingCart {


    private final HashMap<GroceryItem, Integer> itemsInCart;

    public ShoppingCart() {

        this.itemsInCart = new HashMap<>();

    }

    // add 1 unit of selected item
    public void addItem(GroceryItem item) {
        if (this.itemsInCart.containsKey(item)){
            this.itemsInCart.put(item, this.itemsInCart.get(item) + 1);
        }
        else {
            this.itemsInCart.put(item, 1);
        }
    }

    // remove 1 unit of selected item, assume item is in the cart
    public void removeItem(GroceryItem item) {
        if (this.itemsInCart.get(item) == 1){
            this.itemsInCart.remove(item);
        }
        else {
            this.itemsInCart.put(item, this.itemsInCart.get(item) - 1);
        }
    }


    // for future use
    public double getTotalPrice() {

        double total = 0;

        for (GroceryItem i: this.itemsInCart.keySet()) {

            total += i.getDiscountStrategy().discount(i,this);

        }

        return total;

    }

    //helper for the discounters
    public int getItemQuantityInCart(GroceryItem item){

        return this.itemsInCart.get(item);


    }

    //helper for ShoppingCartTest
    public HashMap<GroceryItem, Integer> getItemsInCart(){
        return this.itemsInCart;
    }


}
