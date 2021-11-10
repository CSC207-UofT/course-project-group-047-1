package External_Interface;

import Controllers.AccountManager;
import Controllers.GroceryInventory;
import Controllers.OrderManager;
import Controllers.ShoppingCart;
import java.util.Scanner;


/**
 * This class accepts user input and convert them into system output, and it's the only class that should be run.
 */
public class Main {


    String name;
    Scanner input = new Scanner(System.in);
    AccountManager manager = new AccountManager();
    GroceryInventory items = new GroceryInventory();
    OrderManager Orders = new OrderManager();
    ShoppingCart cart;

    public final String red = "\u001B[31m";
    public final String reset = "\u001B[0m";
    public final String green = "\u001B[32m";
    public final String blue = "\u001B[34m";


    /**
     * a Welcome menu, provide three choices for users
     *
     * choice 1: create an account, which will call createAccountMenu method
     * choice 2: login to an account, which will call loginMenu method
     * choice 3: exit, exit the program
     */
    public void mainMenu(){

        System.out.println(green + "\nWelcome to our store, please select your choice\n" + reset);
        System.out.println("Enter 1 to create account");
        System.out.println("Enter 2 to login to account");
        System.out.println("Enter 3 to Exit");
        System.out.print(blue + "\nEnter your choice: " + reset);
        int num = input.nextInt();
        input.nextLine();

        switch (num) {

            case 1:
                this.createAccountMenu();
                break;

            case 2:
                this.loginMenu();
                break;

            case 3:
                break;

        }

        System.out.println(green + "\nThank you for visiting our store" + reset);
        input.close();
        System.exit(0);
    }


    /**
     * ask the user for their username and pin, call a method in AccountManager
     * that checks the credentials to determine if an account exists. If so, then
     * call customerMenu, if not ask the user to try again or create an account.
     * If an account has an open order, then
     */
    public void loginMenu() {

        String username;
        int pin;
        boolean end = false;

        System.out.println();
        System.out.println(green + "Welcome to login page" + reset);

        while (!end) {

            System.out.print(blue + "\nPlease enter your customer username: " + reset);
            username = input.nextLine();
            System.out.print(blue + "\nPlease enter your PIN number: " + reset);
            pin = input.nextInt();
            input.nextLine();

            if (manager.contains(username, pin)) {

                System.out.println("\nLogin success");
                this.name = username;
                if (Orders.haveOrder(name)) {
                    System.out.println(red + "\nYou have an unfinished order, please complete this order first" + reset);
                    this.confirmMenu();
                } else {
                    this.customerMenu();
                }
                break;

            } else {

                System.out.println(red + "\nWrong username or pin, please create one or try again\n" + reset);
                System.out.println("Enter 1 to create account");
                System.out.println("Enter 2 to try again");
                System.out.print(blue + "\nPlease enter your choice: " + reset);
                int num = input.nextInt();
                input.nextLine();

                switch (num) {

                    case 1:
                        this.createAccountMenu();
                        end = true;
                        break;

                    case 2:
                        break;

                }

            }

        }

    }


    /**
     * ask the user to set up an account by providing a username and pin,
     * then call the loginMenu method
     */
    public void createAccountMenu() {

        String username;
        int pin;

        System.out.println();
        System.out.println(green + "Welcome to create account page" + reset);

        System.out.print(blue + "\nPlease choose your customer username: " + reset);
        username = input.nextLine();
        System.out.print(blue + "\nPlease choose your PIN number: " + reset);
        pin = input.nextInt();
        input.nextLine();

        if (manager.contains(username, pin)) {

            System.out.println(red + "Account already exists, please login" + reset);
            this.loginMenu();

        }

        manager.addCustomer(manager.createAccount(username, pin));
        System.out.println("\nAccount created, please login");
        this.loginMenu();

        System.exit(0);

    }


    /**
     * provide two choices for user
     *
     * choice 1: start shopping, which will call shoppingMenu method
     * choice 2: exit, exit the program
     */
    public void customerMenu() {

        System.out.println();
        System.out.println(green + "Welcome to customer menu, please enter your choice\n" + reset);
        System.out.println("Enter 1 to view item list");
        System.out.println("Enter 2 to Exit");
        System.out.print(blue + "\nEnter your choice: " + reset);
        int num = input.nextInt();
        input.nextLine();
        System.out.println();

        switch (num) {
            case 1 -> {
                this.cart = new ShoppingCart();
                this.shoppingMenu();
            }
            case 2 -> {
                System.out.println(green + "Thank you for visiting our store" + reset);
                System.exit(0);
            }
        }

    }


    public void confirmMenu() {}

    public void shoppingMenu() {}


    public static void main(String[] args) {

        Main m = new Main();
        m.mainMenu();

    }

}
