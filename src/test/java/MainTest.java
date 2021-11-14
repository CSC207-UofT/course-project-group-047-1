import Controllers.AccountManager;
import Controllers.GroceryInventory;
import Controllers.OrderManager;
import Controllers.ShoppingCart;
import External_Interface.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

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

    @Test(timeout = 100)
    public void testMainMenu() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        main.mainMenu();
        String expectedOutput = "\nWelcome to our store, please select your choice\n" +
                "Enter 1 to create account\nEnter 2 to login to account\nEnter 3 to Exit" +
                "\nEnter your choice: ";
        assertEquals(expectedOutput, outputContent.toString());
        if (scanner.hasNext()) {
            if (scanner.nextInt() == 1) {
                assertEquals(true, main.createBool);
            }
            else if (scanner.nextInt() == 2) {
                assertEquals(true, main.loginBool);
            }
        }
        scanner.close();
    }

    @Test(timeout = 50)
    public void testLoginMenu() {
        String u = scanner.nextLine();
        int p = scanner.nextInt();
        main.loginMenu();
        if (accountManager.contains(u, p)) {
            if (orderManager.haveOrder(u)) {
                assertEquals(true, main.confirmBool);
            }
            else {
                assertEquals(true, main.customerBool);
            }
        }
        else if (p == 1) {
            assertEquals(true, main.createBool);
        }
    }

    @Test(timeout = 50)
    public void testCreateAccountMenu() {
        String u = scanner.nextLine();
        int p = scanner.nextInt();
        main.createAccountMenu();
        assertEquals(true, main.loginBool);
    }

    @Test(timeout = 50)
    public void testCustomerMenu() {
        int input = scanner.nextInt();
        main.customerMenu();
        if (input == 1) {
            assertEquals(true, main.shoppingBool);
        }
    }

    @Test(timeout = 50)
    public void testCartMenu() {
        main.cartMenu();
        int input = scanner.nextInt();
        if (!shoppingCart.isEmpty()) {
            if (input == 1) {
                assertEquals(true, main.removeBool);
            }
        }
    }

    @Test(timeout = 50)
    public void testRemoveItem() {
        main.cartMenu();
        int id = scanner.nextInt();
        int quantity = scanner.nextInt();
        /**
         * incomplete
         */
    }

    @Test(timeout = 50)
    public void testCheckOutMenu() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        main.checkOutMenu();
        String expectedOutput = "\nWelcome, your order has been created, you bought " + shoppingCart.getQuantity() +
                " items\nYou need to pay a total of $" + shoppingCart.getTotalPrice() + "Please remember to bring enough" +
                " money and visit our store before 9pm";
        assertEquals(expectedOutput, outputContent.toString());
    }

    @Test(timeout = 50)
    public void testConfirmMenu() {
        main.confirmMenu();
        int input = scanner.nextInt();
        if (input==1) {
            assertFalse(orderManager.haveOrder(main.name));
        }
    }

    @Test(timeout = 50)
    public void testAddItem() {
        main.shoppingMenu();
        int id = scanner.nextInt();
        int amount = scanner.nextInt();
        int original = groceryInventory.getQuantity(id);
        shoppingCart.addItem(groceryInventory.createItem(id, amount));
        assertEquals((original - amount), groceryInventory.getQuantity(id));
    }

    @Test(timeout = 50)
    public void testShoppingMenu() {
        main.shoppingMenu();
        int input = scanner.nextInt();
        if (input==1) {
            assertTrue(main.addBool);
        }
        else if (input==2) {
            assertTrue(main.cartBool);
        }
        else if (input==3) {
            if (!shoppingCart.isEmpty()) {
                assertTrue(main.checkoutBool);
            }
        }
        else if (input==4) {
            assertTrue(shoppingCart.isEmpty());
        }
    }

}