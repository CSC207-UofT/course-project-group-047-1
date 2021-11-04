package External_Interface;

import Controllers.ShoppingCart;
import Entities.GroceryItem;

public class NoDiscounter implements Discounter{

    /**
     * Discount a grocery item.
     * @return returns the discounted price of the selected item, taking into account its quantity in cart.
     */

    @Override
    public double discount(GroceryItem item, ShoppingCart cart) {
        return item.getPrice();
    }
}
