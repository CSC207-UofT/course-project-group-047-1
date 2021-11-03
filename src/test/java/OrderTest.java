import Entities.Customer;
import Entities.GroceryItem;
import Use_Case.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    Order order;
    Customer customer;
    ArrayList<GroceryItem> items = new ArrayList<>();
    GroceryItem apple;
    GroceryItem orange;
    GroceryItem PC;

    @Before
    public void setUp() {
        customer = new Customer("name");
        apple = new GroceryItem(1, "apple", 5.0, 10);
        orange = new GroceryItem(2, "orange", 3.0, 10);
        PC = new GroceryItem(3, "PC", 5000.0, 5);
        items.add(apple);
        items.add(orange);
        items.add(PC);
        order = new Order(customer, items);
    }

    @Test(timeout = 50)
    public void testGetCustomer() {assertEquals(customer, order.getCustomer());}

    @Test(timeout = 50)
    public void testGetItems() {assertEquals(items, order.getItems());}

    @Test(timeout = 50)
    public void testGetTotalQuantity() {assertEquals(3, order.getTotalQuantity());}

    @Test(timeout = 50)
    public void testGetTotalPrice() {assertEquals(5008.0, order.getTotalPrice(), 0.0);}

    @Test(timeout = 50)
    public void testGetCustomerName() {assertEquals("name", order.getCustomerName());}

}