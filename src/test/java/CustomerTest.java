import Entities.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;

    @Before
    public void setUp() {customer = new Customer("name");}

    @Test(timeout = 50)
    public void testGetUsername() {assertEquals("name", customer.getName());}

}