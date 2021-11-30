package use_case_test;

import use_case.CustomerAccount;
import entity.Balance;
import entity.Credit;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerAccountTest {

    CustomerAccount customer1;
    CustomerAccount customer2;
    Credit cred;
    Balance balance;

    @Before
    public void setUp() {
        cred = new Credit(50.0);
        balance = new Balance(50.0);
        customer1 = new CustomerAccount("Adam", 123, cred, balance, "red");
        customer2 = new CustomerAccount("Mike", 135, 20.0, 10.0, "blue");
    }

    @Test(timeout = 50)
    public void testGetUsername() {
        assertEquals("Adam", customer1.getUsername());
        assertEquals("Mike", customer2.getUsername());
    }

    @Test(timeout = 50)
    public void testGetPin() {
        assertEquals(123, customer1.getPin());
        assertEquals(135, customer2.getPin());
    }

    @Test(timeout = 50)
    public void testCred() {
        assertEquals(50.0, customer1.getCred());
        assertEquals(20.0, customer2.getCred());
    }

    @Test(timeout = 50)
    public void testBal() {
        assertEquals(50.0, customer1.getBal());
        assertEquals(10.0, customer2.getBal());
    }

    @Test(timeout = 50)
    public void testGetColor() {
        assertEquals("red", customer1.getColor());
        assertEquals("blue", customer2.getColor());
    }

    @Test(timeout = 50)
    public void testResetUsername() {
        assertEquals("Adam", customer1.getUsername());
        customer1.resetUsername("Mary");
        assertEquals("Mary", customer1.getUsername());
        assertEquals("Mike", customer2.getUsername());
    }

    @Test(timeout = 50)
    public void testResetPin() {
        assertEquals(123, customer1.getPin());
        customer1.resetPin(234);
        assertEquals(234, customer1.getPin());
    }

    @Test(timeout = 50)
    public void testSetColor() {
        assertEquals("red", customer1.getColor());
        customer1.setColor("green");
        assertEquals("green", customer1.getColor());
    }

    @Test(timeout = 50)
    public void testAddCred() {
        assertEquals(50.0, customer1.getCred());
        customer1.addCred(10.0);
        assertEquals(60.0, customer1.getCred());
    }

    @Test(timeout = 50)
    public void testAddBal() {
        assertEquals(50.0, customer1.getBal());
        customer1.addBal(10.0);
        assertEquals(60.0, customer1.getBal());
    }

    @Test(timeout = 50)
    public void testReduceCred() {
        assertEquals(50.0, customer1.getCred());
        customer1.reduceCred(10.0);
        assertEquals(40.0, customer1.getCred());
    }

    @Test(timeout = 50)
    public void testReduceBal() {
        assertEquals(50.0, customer1.getBal());
        customer1.reduceBal(10.0);
        assertEquals(40.0, customer1.getBal());
    }

}
