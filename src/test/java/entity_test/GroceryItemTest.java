package entity_test;

import entities.GroceryItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroceryItemTest {
    GroceryItem item;

    @Before
    public void setUp() {item = new GroceryItem(1, "Grape", 9.99, 20);}

    @Test(timeout = 50)
    public void testGetId() {assertEquals(1, item.getId());}

    @Test(timeout = 50)
    public void testGetPrice() {assertEquals(9.99, item.getPrice(), 0.0);}

    @Test(timeout = 50)
    public void testGetName() {assertEquals("Grape", item.getName());}

    @Test(timeout = 50)
    public void testGetQuantity() {assertEquals(20, item.getQuantity());}

    @Test(timeout = 50)
    public void testReduce() {
        item.reduce(0);
        assertEquals(20, item.getQuantity());
        item.reduce(10);
        assertEquals(10, item.getQuantity());
    }

    @Test(timeout = 50)
    public void testAdd() {
        item.add(0);
        assertEquals(20, item.getQuantity());
        item.add(10);
        assertEquals(30, item.getQuantity());
    }


}
