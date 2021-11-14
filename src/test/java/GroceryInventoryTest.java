import java.io.*;
import java.util.Hashtable;

import Controllers.GroceryInventory;
import Controllers.ShoppingCart;
import Entities.GroceryItem;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GroceryInventoryTest {

    GroceryInventory groceryInventory;
    GroceryItem groceryItem1;
    GroceryItem groceryItem2;
    ShoppingCart shoppingCart;

    @Before
    public void setUp() {
        groceryInventory = new GroceryInventory();
        groceryItem1 = new GroceryItem(1, "Grape", 1.99, 20);
        groceryItem2 = new GroceryItem(2, "Orange", 2.99, 10);
        shoppingCart = new ShoppingCart();
    }

    @Test(timeout = 50)
    public void testCreateItem() {
        assertEquals(groceryItem1, groceryInventory.createItem(1, 20));
    }

    @Test(timeout = 50)
    public void testGetQuantity() {
        assertEquals(20, groceryInventory.getQuantity(1));
    }

    @Test(timeout = 50)
    public void testAdd() {
        groceryInventory.createItem(1, 20);
        groceryInventory.add(1, 5);
        int actual = groceryInventory.getQuantity(1);
        assertEquals(25, actual);
    }

    @Test(timeout = 50)
    public void testReduce() {
        groceryInventory.reduce(1, 5);
        assertEquals(15, groceryInventory.getQuantity(1));
    }

    @Test(timeout = 50)
    public void testPutBack() {
        groceryInventory.putBack(shoppingCart.getItems());
        assertEquals(true, shoppingCart.isEmpty());
    }

    @Test(timeout = 50)
    public void testView() {
        groceryInventory.createItem(1, 20);
        groceryInventory.add(1, 20);
        assertEquals("1 Grape x 20, Price: 1.99$ each", groceryInventory.view());
    }

    @Test(timeout = 50)
    public void testUpdateInventory() {
        groceryInventory.add(1, 20);
        groceryInventory.updateInventory();
        assertEquals("1 Grape x 20, Price: 1.99$ each", groceryInventory.view());
    }

}
