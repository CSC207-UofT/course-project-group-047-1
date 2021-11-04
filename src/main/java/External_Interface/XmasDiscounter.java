package External_Interface;

import Controllers.ShoppingCart;

import Entities.GroceryItem;


public class  XmasDiscounter implements Discounter {

    /**
     * Discount strategy: apply the Xmas season discount: 10% off for selected items.
     * @return returns the discounted price of the selected item, taking into account its quantity in cart.
     */
    @Override
    public double discount(GroceryItem item, ShoppingCart cart) {

        return item.getPrice() * cart.getItemQuantityInCart(item) * 0.9;

    }


}