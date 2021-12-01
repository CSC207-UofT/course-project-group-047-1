package external_interface_test;

import entity.GroceryItem;
import external_interface.InventoryAccess;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryAccessTest {

    InventoryAccess inventoryAccess = new InventoryAccess();
    private final ArrayList<GroceryItem> items = inventoryAccess.read();


    /**
     * Test the accuracy of file writing and reading
     */
    @Test(timeout = 50)
    public void testRead(){
        assertEquals(5, items.size());
        String name = items.get(0).getName();
        assertEquals("Apple", name);
        name = items.get(4).getName();
        assertEquals("mask", name);
    }


    @Test(timeout = 50)
    public void testWrite() {
        inventoryAccess.update(this.items);
        ArrayList<GroceryItem> sample = inventoryAccess.read();
        assertEquals(this.items.size(), sample.size());
    }

    
}
