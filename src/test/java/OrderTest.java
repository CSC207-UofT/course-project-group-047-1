import Entities.Customer;
import Entities.GroceryItem;
import Use_Case.Order;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    Order order1;
    Order order2;
    Order order3;
    Customer customer;
    GroceryItem apple;
    GroceryItem orange;
    GroceryItem PC;
    String name;

    @Before
    public void setUp() {
        customer = new Customer("name");
        apple = new GroceryItem(1, "apple", 5.0, 10);
        orange = new GroceryItem(2, "orange", 3.0, 10);
        PC = new GroceryItem(3, "PC", 5000.0, 5);
        this.name = customer.getName();
        int amount = apple.getQuantity() + orange.getQuantity() + PC.getQuantity();
        double price = apple.getPrice()*apple.getQuantity()+ PC.getPrice()*PC.getQuantity()+
                orange.getPrice()*orange.getQuantity();
        order1 = new Order(this.name, amount, price);
        order2 = new Order(customer, amount, price);
        order3 = new Order(this.name, amount, price, "closed");
    }


    @Test(timeout = 50)
    public void testGetCustomer() {
        assertEquals(this.name, order1.getCustomer());
        assertEquals(this.name, order2.getCustomer());
    }


    @Test(timeout = 50)
    public void testGetTotalQuantity() {
        assertEquals(25, order1.getTotalQuantity());
        assertEquals(25, order2.getTotalQuantity());
    }


    @Test(timeout = 50)
    public void testGetValue() {
        assertEquals(25080.0, order1.getValue(), 0.0);
        assertEquals(25080.0, order2.getValue(), 0.0);
    }


    @Test(timeout = 50)
    public void testGetStatus() {
        assertEquals("open", order1.getStatus());
        assertEquals("open", order2.getStatus());
        assertEquals("closed", order3.getStatus());
    }


    @Test(timeout = 50)
    public void testSetStatus() {
        order1.setStatus("open");
        assertEquals("open", order1.getStatus());
    }


}
