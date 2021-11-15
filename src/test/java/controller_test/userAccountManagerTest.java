package controller_test;

import controllers.CustomerAccountManager;
import entities.Customer;
import use_case.CustomerAccount;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class userAccountManagerTest {


    CustomerAccountManager userAccountManager;
    Customer customer1;
    CustomerAccount customerAccount1;


    @Before
    public void setUp() {
        userAccountManager = new CustomerAccountManager();
        customer1 = new Customer("name");
        customerAccount1 = new CustomerAccount(customer1, 12345);
    }


    @Test(timeout = 50)
    public void testAddAccount() {
        userAccountManager.addAccount(customerAccount1);
        assertTrue(userAccountManager.contains("name", 12345));
    }


    @Test(timeout = 50)
    public void testContains() {
        userAccountManager.addAccount(customerAccount1);
        assertTrue(userAccountManager.contains("name", 12345));
    }


}
