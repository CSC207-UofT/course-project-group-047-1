import Controllers.AccountManager;
import Controllers.GroceryInventory;
import Controllers.OrderManager;
import Controllers.ShoppingCart;
import External_Interface.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class MainTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    AccountManager accountManager;
    GroceryInventory groceryInventory;
    OrderManager orderManager;
    ShoppingCart shoppingCart;
    Scanner scanner;
    Main main;


    @Before
    public void setUp() {
        accountManager = new AccountManager();
        groceryInventory = new GroceryInventory();
        orderManager = new OrderManager();
        shoppingCart = new ShoppingCart();
        scanner = new Scanner(System.in);
        main = new Main();
    }


    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }


    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }


    private String getOutput() {
        return testOut.toString();
    }


    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }


    @Test(timeout = 50)
    public void testMainMenu() {
        main.mainMenu();
    }


    @Test(timeout = 50)
    public void testLoginMenu() {
    }

    @Test(timeout = 50)
    public void testCreateAccountMenu() {
    }

    @Test(timeout = 50)
    public void testCustomerMenu() {
    }

    @Test(timeout = 50)
    public void testCartMenu() {
    }

    @Test(timeout = 50)
    public void testRemoveItem() {
    }

    @Test(timeout = 50)
    public void testCheckOutMenu() {
    }

    @Test(timeout = 50)
    public void testConfirmMenu() {

    }

    @Test(timeout = 50)
    public void testAddItem() {

    }

    @Test(timeout = 50)
    public void testShoppingMenu() {

    }

    @Test(timeout = 50)
    public void testMain() {

    }

}