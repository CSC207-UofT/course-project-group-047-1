package External_Interface;

import Controllers.ShoppingCart;
import Entities.GroceryItem;

public interface Discounter {

    /**
     * design pattern: Strategy
     * Discount a grocery item.
     * @return returns the discounted price of the selected item, taking into account its quantity in cart.
     */
     double discount(GroceryItem item, ShoppingCart cart);
}
