import Controllers.ShoppingCart;
import Entities.GroceryItem;
import External_Interface.BuyOneGetOneFreeDiscounter;
import External_Interface.XmasDiscounter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ShoppingCartTest {
    ShoppingCart cart;
    GroceryItem apple;
    GroceryItem banana;
    GroceryItem grape;

    @Before
    public void setUp() {
        cart = new ShoppingCart();
        apple = new GroceryItem(1001, "apple", 2, 20);
        banana = new GroceryItem(1002, "banana", 4, 20);
        grape = new GroceryItem(1, "grape", 6, 20); //it has no discount
        apple.setDiscounter(new BuyOneGetOneFreeDiscounter());
        banana.setDiscounter(new XmasDiscounter());
    }


    @Test
    public void addItem() {
        cart.addItem(apple);
        int appleq = cart.getItemQuantityInCart(apple);
        assertEquals(1, appleq);

        cart.addItem(apple);
        appleq = cart.getItemQuantityInCart(apple);
        assertEquals(2, appleq);

    }

    @Test
    public void removeItemQuantityMoreThanOne() {
        cart.addItem(apple);
        cart.addItem(apple);
        cart.removeItem(apple);
        int appleq = cart.getItemQuantityInCart(apple);
        assertEquals(1, appleq);
        cart.removeItem(apple);
        assertFalse(cart.getItemsInCart().containsKey(apple));

    }

    @Test
    public void removeItemQuantityOne() {
        cart.addItem(apple);
        cart.removeItem(apple);
        assertFalse(cart.getItemsInCart().containsKey(apple));
    }

    @Test
    public void getTotalPrice() {
        cart.addItem(apple);
        cart.addItem(apple);
        cart.addItem(banana);
        cart.addItem(banana);
        cart.addItem(grape);
        assertEquals(15.2,cart.getTotalPrice(),0.001);
    }

}
