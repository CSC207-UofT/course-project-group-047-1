package use_case_test;

import use_case.Order;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    Order order;

    @Before
    public void setUp() {
        order = new Order("Adam", 5, 20.0, "open");
    }

    /**
     * Test for the getCustomer method.
     */
    @Test(timeout = 50)
    public void testGetCustomer() {
        assertEquals("Adam", order.getCustomer());
    }

    /**
     * Test for the getValue method.
     */
    @Test(timeout = 50)
    public void testGetValue() {
        assertEquals(20.0, order.getValue());
    }

    /**
     * Test for the getTotalQuantity method.
     */
    @Test(timeout = 50)
    public void testGetTotalQuantity() {
        assertEquals(5, order.getTotalQuantity());
    }

    /**
     * Test for the getStatus method.
     */
    @Test(timeout = 50)
    public void testGetStatus() {
        assertEquals("open", order.getStatus());
    }

    /**
     * Test for the setStatus method.
     */
    @Test(timeout = 50)
    public void testSetStatus() {
        order.setStatus("closed");
        assertEquals("closed", order.getStatus());
    }

    /**
     * Test for the returnInfo method.
     */
    @Test(timeout = 50)
    public void testReturnInfo() {
        String expected = "Status: open\nTotal number of items: 5\nTotal price: 20.0\n\n";
        assertEquals(expected, order.returnInfo());
    }

    /**
     * Test for the resetUsername method.
     */
    @Test(timeout = 50)
    public void testResetUsername() {
        order.resetUsername("Mary");
        assertEquals("Mary", order.getCustomer());
    }

}
