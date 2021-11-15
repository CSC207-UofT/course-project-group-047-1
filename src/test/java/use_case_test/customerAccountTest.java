package use_case_test;

import use_case.CustomerAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class customerAccountTest {

    CustomerAccount customerAccount;

    @Before
    public void setUp() {
        customerAccount = new CustomerAccount("username", 12345);}

    @Test(timeout = 50)
    public void testGetUsername() {assertEquals("username", customerAccount.getUsername());}

    @Test(timeout = 50)
    public void testGetPin() {assertEquals(12345, customerAccount.getPin());}

}

