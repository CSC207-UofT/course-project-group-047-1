import Entities.Customer;
import Use_Case.Order;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class OrderManagerTest {
    String path;
    Order order;
    Customer customer;
    int amount;
    Double price;

    @Before
    public void setUp() {
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                "main" + File.separator + "java" + File.separator + "Files" + File.separator + "Orders.txt";
        customer = new Customer("cos1");
        amount = 2;
        price =
        order = new Order(Customer customer, int amount, Double price);
    }

    @Test(timeout = 50)
    public void testaddOrder() {
    }

    @Test(timeout = 50)
    public void testhaveOrder() {
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