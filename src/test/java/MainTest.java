

import Controllers.AccountManager;
import Controllers.GroceryInventory;
import Controllers.OrderManager;
import Controllers.ShoppingCart;
import External_Interface.Main;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;
import static org.junit.Assert.assertTrue;

public class MainTest {

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

    @Test(timeout = 50)
    public void testMainMenu() {
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