package Controllers;

import Entities.Customer;

import java.io.*;
import java.util.Hashtable;

import Use_Case.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AccountManagerTest {

    AccountManager accountManager;
    Customer customer1;
    Account account1;

    @Before
    public void setUp() {
        accountManager = new AccountManager();
        customer1 = new Customer("name");
        account1 = new Account(customer1, 12345);
    }

    @Test(timeout = 50)
    public void testAddCustomer() {
        accountManager.addCustomer(account1);
        assertEquals(true, accountManager.contains("name", 12345));
    }

    @Test(timeout = 50)
    public void testContains() {
        accountManager.addCustomer(account1);
        assertEquals(accountManager.contains("name", 12345), true);
    }
}
