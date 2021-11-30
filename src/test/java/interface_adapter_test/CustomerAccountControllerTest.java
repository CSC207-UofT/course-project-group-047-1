package interface_adapter_test;

import entity.Balance;
import entity.Credit;
import external_interface.CustomerAccountAccess;
import interface_adapter.CustomerAccountController;
import org.junit.Before;
import org.junit.Test;
import use_case.CustomerAccount;
import use_case.CustomerDataAccess;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerAccountControllerTest {

    CustomerAccountController CAController;
    CustomerDataAccess db = new CustomerAccountAccess();
    Credit cred;
    Balance balance;
    CustomerAccount account1;
    CustomerAccount account2;


    @Before
    public void setUp() {
        CAController = new CustomerAccountController(db);
        balance = new Balance();
        cred = new Credit(100.00);
        account1 = new CustomerAccount("name", 12345, cred, balance, "all_black");
        account2 = new CustomerAccount("ats", 12345, cred, balance, "all_black");
        CAController.addAccount(account1);
    }

    @Test(timeout = 50)
    public void testAddAccount() {
        CAController.addAccount(account2);
        assertTrue(CAController.exists("ats"));
    }

    @Test(timeout = 50)
    public void testCheck() {
        assertTrue(CAController.check("name", 12345));
        assertFalse(CAController.check("name", 12456));
        assertFalse(CAController.check("Apple", 12345));
    }

    @Test(timeout = 50)
    public void testExists() {
        assertTrue(CAController.exists("name"));
        assertFalse(CAController.exists("hello"));
    }

    @Test(timeout = 50)
    public void testChangeColor(){
        CAController.changeColor("name", "invert");
        assertEquals("invert", account1.getColor());
    }

    @Test(timeout = 50)
    public void testChangeUsername() {
        CAController.changeUsername("name", "name_2");
        assertEquals("name_2", account1.getUsername());
    }

    @Test(timeout = 50)
    public void testChangePin() {
        CAController.changePin("name", 23456);
        assertEquals(23456, account1.getPin());
    }

    @Test(timeout = 50)
    public void testAddBalance() {
        CAController.addBalance("name", 12.33);
        assertEquals(12.33, account1.getBal());
    }

    @Test(timeout = 50)
    public void testReduceBal() {
        CAController.addBalance("name", 12.33);
        CAController.reduceBal("name", 2.33);
        assertEquals(10.00, account1.getBal());
    }

    @Test(timeout = 50)
    public void testAddCredit() {
        CAController.addCredit("name", 12.33);
        assertEquals(112.33, account1.getCred());

    }

}