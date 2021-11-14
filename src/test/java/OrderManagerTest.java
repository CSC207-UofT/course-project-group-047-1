import Controllers.OrderManager;
import Entities.Customer;
import Entities.GroceryItem;
import Use_Case.Order;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderManagerTest {
    String path;
    Order order;
    Customer customer;
    int amount;
    Double price;
    String status;
    OrderManager manager;

    @Before
    public void setUp() {
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                "main" + File.separator + "java" + File.separator + "Files" + File.separator + "Orders.txt";
        customer = new Customer("cos1");
        amount = 10;
        price = 130.23;
        order = new Order(customer, amount, price);
        status = order.getStatus();
        manager = new OrderManager();
    }

    @Test(timeout = 50)
    public void testaddOrder() {
        manager.addOrder(order);
        assertTrue(manager.haveOrder(order.getCustomer()));

    }

    @Test(timeout = 50)
    public void testhaveOrder() {
        manager.addOrder(order);

    }

    @Test(timeout = 50)
    public void testcloseAll() {
    }

    @Test(timeout = 50)
    public void testclear() {
    }

    @Test(timeout = 50)
    public void testupdate() {
    }
}