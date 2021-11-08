import Entities.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer1;
    Customer customer2;

    @Before
    public void setUp() {
        customer1 = new Customer("name");
        customer2 = new Customer("name");
        customer2.ChangeName("Hi");
    }

    @Test(timeout = 50)
    public void testGetUsername() {
        assertEquals("name", customer1.getName());
        assertEquals("Hi", customer2.getName());
    }

}
