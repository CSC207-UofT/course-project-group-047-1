package interface_adapter_test;

import entity.Balance;
import entity.Credit;
import interface_adapter.CustomerAccountController;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.CustomerAccount;
import use_case.CustomerDataAccess;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerAccountControllerTest {

    CustomerAccountController CAcontroller;
    CustomerDataAccess db;
    Credit cred;
    Balance balance;
    CustomerAccount account1;



    @BeforeEach
    public void setUp() {
        CAcontroller = new CustomerAccountController(db);
        balance = new Balance();
        cred = new Credit(100.00);
        account1 = new CustomerAccount("name", 12345, cred, balance, "all_black");

    }

    @Test
    public void testAddAccount() {
        CAcontroller.addAccount(account1);
        assertTrue(CAcontroller.exists("name"));
    }

    @Test
    public void testCheck() {
        CAcontroller.addAccount(account1);
        assertTrue(CAcontroller.check("name", 12345));
        assertFalse(CAcontroller.check("name", 12456));
        assertFalse(CAcontroller.check("jisdjgisbn", 12345));
    }

    @Test
    public void testExists() {
        CAcontroller.addAccount(account1);
        assertTrue(CAcontroller.exists("name"));
        assertTrue(CAcontroller.exists("hello"));
    }

    @Test
    public void testChangeColor(){
        CAcontroller.addAccount(account1);
        CAcontroller.changeColor("name", "invert");
        assertEquals("invert", account1.getColor());
    }

    @Test
    public void testChangeUsername() {
        CAcontroller.addAccount(account1);
        CAcontroller.changeUsername("name", "name_2");
        assertEquals("name_2", account1.getUsername());
    }

    @Test
    public void testChangePin() {
        CAcontroller.addAccount(account1);
        CAcontroller.changePin("name", 23456);
        assertEquals(23456, account1.getPin());
    }

    @Test
    public void testAddBalance() {
        CAcontroller.addAccount(account1);
        CAcontroller.addBalance("name", 12.33);
        assertEquals(112.33, account1.getBal());
    }

    @Test
    public void testReduceBal() {
        CAcontroller.addAccount(account1);
        CAcontroller.addBalance("name", 12.33);
        CAcontroller.reduceBal("name", 2.33);
        assertEquals(10.00, account1.getBal());
    }

    @Test
    public void testAddCredit() {
        CAcontroller.addAccount(account1);
        CAcontroller.addCredit("name", 12.33);
        assertEquals(112.33, account1.getCred());
    }
}