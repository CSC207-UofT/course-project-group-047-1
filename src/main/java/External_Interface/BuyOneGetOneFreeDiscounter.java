package External_Interface;

import Entities.GroceryItem;

import Controllers.ShoppingCart;

public class  BuyOneGetOneFreeDiscounter implements Discounter {

    /**
     * Discount strategy: buy one get one free, can be applied only once for each type of item
     * regardless of its quantity in shopping cart.
     * @return returns the discounted price of the selected item, taking into account its quantity in cart.
     */
    @Override
    public double discount(GroceryItem item, ShoppingCart cart) {

        return item.getPrice() + item.getPrice() * (cart.getItemQuantityInCart(item) - 2);

    }


}