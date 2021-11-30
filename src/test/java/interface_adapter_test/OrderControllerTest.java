package interface_adapter_test;

import interface_adapter.OrderController;
import use_case.Order;
import use_case.OrderDataAccess;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class OrderControllerTest {

    OrderController oc;
    OrderDataAccess db;
    ArrayList<Order> orders;
    Order order;

    @Before
    public void setUp() {
        oc = new OrderController(db);
        db = new OrderDataAccess() {
            @Override
            public ArrayList<Order> read() {
                return null;
            }

            @Override
            public void update(ArrayList<Order> orders) {

            }
        };
        orders = new ArrayList<Order>();
        order = new Order("Adam", 5, 20.0, "open");
    }

    /**
     * above doesn't work, will fix
     */

    @Test(timeout = 50)
    public void testAddOrder() {
        oc.addOrder(order);
        /**
         * need to add something to check it's in the db
         */
    }

    @Test(timeout = 50)
    public void testHaveOpenOrder() {
        assertEquals(true, oc.haveOpenOrder("Adam"));
    }

    @Test(timeout = 50)
    public void testCloseAll() {
        oc.closeAll("Adam");
        assertEquals(false, oc.haveOpenOrder("Adam"));
    }

    @Test(timeout = 50)
    public void testChangeName() {
        oc.changeName("Adam", "Mary");
        assertEquals("Mary", order.getCustomer());
        /**
         * this one might be incorrect
         */
    }

    @Test(timeout = 50)
    public void testHaveOrder() {
        assertEquals(true, oc.haveOrder("Adam"));
    }

}
