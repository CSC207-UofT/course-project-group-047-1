package Controllers;

import Use_Case.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerTest {
    AccountManager manager;
    Account account1;
    Account account2;
    String path;


    @Before
    public void setUp() {
        manager = new AccountManager();
        account1 = new Account("username1", 12345);
        account2 = new Account("username2", 67890);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                "main" + File.separator + "java" + File.separator + "Files" + File.separator + "Accounts.txt";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testaddCustomer() {
        manager.addCustomer(account1);
        String line1;
        String line2 = null;
        String line3 = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line1 = reader.readLine()) != null) {
                line3 = line1;
                line2 = reader.readLine();
            }
            Assertions.assertEquals("username1", line3);
            Assertions.assertEquals("12345", line2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testcontains() {
        assertTrue(manager.contains(account1.getUsername(), account1.getPin()));
        assertFalse(manager.contains(account2.getUsername(), account2.getPin()));
    }
}