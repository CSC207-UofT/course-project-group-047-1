package interface_adapter_test;

import entity.GroceryItem;
import external_interface.InventoryAccess;
import interface_adapter.InventoryController;
import org.junit.Before;
import org.junit.Test;
import use_case.InventoryDataAccess;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryControllerTest {
    InventoryController GroIn;
    InventoryDataAccess db = new InventoryAccess();
    ArrayList<GroceryItem> items;
    GroceryItem apple;

    @Before
    public void setUp() {
        GroIn = new InventoryController(db);
        apple = new GroceryItem(1, "Apple", 4.0, 5);
        items = new ArrayList<GroceryItem>();
        items.add(apple);
    }

    @Test(timeout = 50)
    public void testExists() {
        assertTrue(GroIn.exists(2));
        assertFalse(GroIn.exists(10));
    }

    @Test(timeout = 50)
    public void testAdd() {
        GroIn.add(1,5);
        assertEquals(105, GroIn.getQuantity(1));
        GroIn.add(1, 10);
        assertEquals(115, GroIn.getQuantity(1));
        GroIn.reduce(1,15);
    }

    @Test(timeout = 50)
    public void testPutBack() {
        GroIn.putBack(items);
        assertEquals(105, GroIn.getQuantity(1));
        assertEquals(100, GroIn.getQuantity(2));
        GroIn.reduce(1,5);
    }

    @Test(timeout = 50)
    public void testCreateItem() {
        assertEquals(apple.getId(), GroIn.createItem(1, 5).getId());
        assertEquals(apple.getName(), GroIn.createItem(1, 5).getName());
        assertEquals(apple.getPrice(), GroIn.createItem(1, 5).getPrice());
        assertEquals(apple.getQuantity(), GroIn.createItem(1, 5).getQuantity());
    }

    @Test(timeout = 50)
    public void testGetQuantity() {
        assertEquals(100, GroIn.getQuantity(3));
        assertEquals(100, GroIn.getQuantity(4));
    }

    @Test(timeout = 50)
    public void testReduce() {
        GroIn.reduce(1,10);
        assertEquals(90, GroIn.getQuantity(1));
        GroIn.reduce(1, 20);
        assertEquals(70, GroIn.getQuantity(1));
        GroIn.add(1,30);
    }
}