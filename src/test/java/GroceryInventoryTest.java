import java.util.ArrayList;
import Controllers.GroceryInventory;
import Entities.GroceryItem;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GroceryInventoryTest {

    GroceryInventory groceryInventory;


    @Before
    public void setUp() {
        groceryInventory = new GroceryInventory();
    }


    @Test(timeout = 50)
    public void testCreateItem() {
        GroceryItem n = groceryInventory.createItem(5, 10);
        assertEquals(10, n.getQuantity());
    }


    @Test(timeout = 50)
    public void testGetQuantity() {
        assertEquals(100, groceryInventory.getQuantity(5));
    }


    @Test(timeout = 50)
    public void testAdd() {
        groceryInventory.add(5, 5);
        assertEquals(105, groceryInventory.getQuantity(5));
        groceryInventory.reduce(5, 5);
    }


    @Test(timeout = 50)
    public void testReduce() {
        groceryInventory.reduce(4, 5);
        assertEquals(95, groceryInventory.getQuantity(4));
        groceryInventory.add(4,5);
    }


    @Test(timeout = 50)
    public void testPutBack() {
        ArrayList<GroceryItem> items = new ArrayList<>();
        items.add(groceryInventory.createItem(5, 1));
        groceryInventory.putBack(items);
        assertEquals(101, groceryInventory.getQuantity(5));
        groceryInventory.reduce(5, 1);
    }


}
