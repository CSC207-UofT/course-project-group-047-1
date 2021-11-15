import controllers.ShoppingCart;
import entities.GroceryItem;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class ShoppingCartTest {


    ShoppingCart cart;
    GroceryItem item1;
    GroceryItem item2;


    @Before
    public void setUp() {
        cart = new ShoppingCart();
        item1 = new GroceryItem(1, "Grape", 9.99, 20);
        item2 = new GroceryItem(2, "Orange", 8.88, 30);
        cart.addItem(item2);

    }


    @Test(timeout = 50)
    public void testAddItem() {
        boolean have = false;
        cart.addItem(item1);
        for (GroceryItem i: cart.getItems()) {
            if (i == item1) {
                have = true;
                break;
            }
        }
        assertTrue(have);
    }


    @Test
    public void testRemoveItem() {
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
    public void testGetTotalPrice() {
        cart.addItem(item1);
        assertEquals(466.20, cart.getTotalPrice(), 5.0);
    }


    @Test
    public void testisEmpty() {
        assertFalse(cart.isEmpty());
        cart.removeItem(item2.getId(), 30);
        assertTrue(cart.isEmpty());
    }


    @Test
    public void testView() {
        String s = cart.view();
        assertEquals("2 Orange x 30, Price: 8.88$ each\n", s);
    }


    @Test
    public void testGetQuantity() {
        assertEquals(cart.getQuantity(), 30);
        cart.addItem(item1);
        assertEquals(cart.getQuantity(), 50);
    }


    @Test
    public void testGetItems() {
        ArrayList<GroceryItem> c = new ArrayList<>();
        c.add(item2);
        assertEquals(c, cart.getItems());
    }


    @Test
    public void testGetAmount() {
        assertEquals(30, cart.getAmount(2));
        cart.addItem(item1);
        assertEquals(20, cart.getAmount(1));
    }


}