import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;

    @Before
    public void setUp() {customer = new Customer("username", 12345,
            "123@utoronto.ca", "address");}

    @Test(timeout = 50)
    public void testGetUsername() {assertEquals("username", customer.getUsername());}

    @Test(timeout = 50)
    public void testGetPin() {assertEquals(12345, customer.getpin());}

}
