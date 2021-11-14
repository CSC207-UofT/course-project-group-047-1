import Controllers.ShoppingCart;
import Entities.GroceryItem;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    ShoppingCart cart;
    GroceryItem item1;
    GroceryItem item2;


    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
        item1 = new GroceryItem(1, "Grape", 9.99, 20);
        item2 = new GroceryItem(2, "Orange", 8.88, 30);
        cart.addItem(item2);

    }

    @Test
    public void testaddItem() {
        boolean have = false;
        cart.addItem(item1);
        for (GroceryItem i: cart.getItems()) {
            if (i == item1){
                have = true;
            }
        }
        assertEquals(true, have);
    }

    @Test
    public void testremoveItem() {
        GroceryItem target = item1;
        cart.removeItem(item2.getId(), 2);
        for (GroceryItem i: cart.getItems()) {
            if (i == item2) {
                target = i;
            }
        }
        assertEquals(2, target.getId());
        assertEquals(28, target.getQuantity());
    }

    @Test
    public void testgetTotalPrice() {
        cart.addItem(item1);
        assertEquals(466.20, cart.getTotalPrice());
    }

    @Test
    public void testisEmpty() {
        assertFalse(cart.isEmpty());
        cart.removeItem(item2.getId(), 30);
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testview() {
        String s = cart.view();
        assertEquals("2 Orange x 30, Price: 8.88$ each\n", s);
    }

    @Test
    public void testgetQuantity() {
        assertEquals(cart.getQuantity(), 30);
        cart.addItem(item1);
        assertEquals(cart.getQuantity(), 50);
    }

    @Test
    public void testgetItems() {
        ArrayList<GroceryItem> c = new ArrayList<GroceryItem>();
        c.add(item2);
        assertEquals(c, cart.getItems());
    }

    @Test
    public void testgetAmount() {
        assertEquals(30, cart.getAmount(2));
        cart.addItem(item1);
        assertEquals(20, cart.getAmount(1));
    }
}