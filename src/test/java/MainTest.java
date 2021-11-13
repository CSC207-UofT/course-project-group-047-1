package External_Interface;

import Controllers.AccountManager;
import Controllers.GroceryInventory;
import Controllers.OrderManager;
import Controllers.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
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
        int input = scanner.nextInt();
        main.mainMenu();
        if (input == 1) {
            assertTrue(main.createBool);
        }
        else if (input == 2) {
            assertTrue(main.loginBool);
        }
    }

    @Test(timeout = 50)
    public void testLoginMenu() {
        int p = scanner.nextInt();
        String u = scanner.nextLine();
        main.loginMenu();
        if (accountManager.contains(u, p)) {
            if (orderManager.haveOrder(u)) {
                assertTrue(main.confirmBool);
            }
            else {
                assertTrue(main.customerBool);
            }
        }
        else if (p == 1) {
            assertTrue(main.createBool);
        }
    }

    @Test(timeout = 50)
    public void testCreateAccountMenu() {
        int p = scanner.nextInt();
        String u = scanner.nextLine();
        main.createAccountMenu();
        assertTrue(main.loginBool);
    }

    @Test(timeout = 50)
    public void testCustomerMenu() {
        int input = scanner.nextInt();
        main.customerMenu();
        if (input == 1) {
            assertTrue(main.shoppingBool);
        }
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