package interface_adapter_test;

import external_interface.OrderAccess;
import interface_adapter.OrderController;
import org.junit.Before;
import org.junit.Test;
import use_case.Order;
import use_case.OrderDataAccess;


import static org.junit.jupiter.api.Assertions.*;

public class OrderControllerTest {
    OrderController OrderCon;
    OrderDataAccess db = new OrderAccess();
    Order order1;

    @Before
    public void setUp() {
        OrderCon = new OrderController(db);
        order1 = new Order("User1", 1, 10.0, "open");
    }

    @Test(timeout = 50)
    public void testAddOrder() {
       OrderCon.addOrder(order1);
       assertTrue(OrderCon.haveOrder("User1"));
    }

    @Test(timeout = 50)
    public void testHaveOpenOrder() {
        assertTrue(OrderCon.haveOpenOrder("User1"));
    }

    @Test(timeout = 50)
    public void testCloseAll() {
        OrderCon.closeAll("User1");
        assertFalse(OrderCon.haveOpenOrder("User1"));
    }

    @Test(timeout = 50)
    public void testChangeName() {
        OrderCon.changeName("User1", "User2");
        assertTrue(OrderCon.haveOrder("User2"));
        assertFalse(OrderCon.haveOrder("User1"));
    }

    @Test(timeout = 50)
    public void testHaveOrder() {
        assertTrue(OrderCon.haveOrder("User1"));
        assertFalse(OrderCon.haveOrder("user"));
    }
}