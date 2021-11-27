package external_interface;

import controllers.CustomerAccountController;
import controllers.GroceryInventory;
import controllers.OrderManager;
import controllers.ShoppingCart;
import use_case.CustomerAccount;
import use_case.Order;

import java.util.Scanner;


/**
 * This class accepts user input and convert them into system output, and it is the only class that should be run.
 */
public class Main {


    String name;
    Scanner input = new Scanner(System.in);
    CustomerAccountController manager = new CustomerAccountController(new CustomerAccountAccess());
    GroceryInventory items = new GroceryInventory();
    OrderManager Orders = new OrderManager();
    ShoppingCart cart;

    //For colorful text
    public final String red = "\u001B[31m";
    public final String reset = "\u001B[0m";
    public final String green = "\u001B[32m";
    public final String blue = "\u001B[34m";


    /**
     * A welcome menu that provides three choices for the users
     *
     * Choice 1: create an account, which will call the createAccountMenu method
     * Choice 2: login to an account, which will call the loginMenu method
     * Choice 3: exit, will exit the program
     */
    public void mainMenu() {

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
     * Asks the user for their username and pin, calls a method in the CustomerAccountController
     * that checks the credentials to determine if an account exists. If so, then
     * calls the customerMenu. If not, asks the user to try again or create an account.
     * If an account has an open order, then calls the confirmMenu.
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

            if (manager.check(username, pin)) {

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
     * Asks the user to set up an account by providing a username and pin,
     * then calls the loginMenu method
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

        if (manager.check(username, pin)) {

            System.out.println(red + "\nCustomerAccount already exists, please login" + reset);
            this.loginMenu();

        }

        CustomerAccount a = new CustomerAccount(username, pin, 0.0, 0.0, "default");
        manager.addAccount(a);
        System.out.println("\nCustomerAccount created, please login");
        this.loginMenu();

        System.exit(0);

    }


    /**
     * Provides two choices for the user
     *
     * Choice 1: start shopping, which will call the shoppingMenu method
     * Choice 2: exit, will exit the program
     */
    public void customerMenu() {

        System.out.println();
        System.out.println(green + "Welcome to customer menu, please enter your choice\n" + reset);
        System.out.println("Enter 1 to start shopping");
        System.out.println("Enter 2 to Exit");
        System.out.print(blue + "\nEnter your choice: " + reset);
        int num = input.nextInt();
        input.nextLine();
        System.out.println();

        switch (num) {
            case 1:
                this.cart = new ShoppingCart();
                this.shoppingMenu();
                break;

            case 2:
                System.out.println(green + "Thank you for visiting our store" + reset);
                System.exit(0);
                break;
            }
        }




    /**
     * Displays the items in the user's shopping cart
     * Offers user two choices
     *
     * Choice 1: remove items from their shopping cart
     * Choice 2: go back to the shoppingMenu
     */
    public void cartMenu() {

        boolean end = false;

        while (!end) {
            if (cart.isEmpty()) {
                System.out.println(red + "\nyou have nothing in your cart, please continue shopping or exit" + reset);
                end = true;
            } else {
                System.out.println(green + "\nBelow is what you have in your shopping cart\n" + reset);
                System.out.println(this.cart.view());
                System.out.println("\nEnter 1 to remove items");
                System.out.println("Enter 2 to go back shopping");
                System.out.print(blue + "\nPlease enter your choice: " + reset);
                int num = input.nextInt();

                switch (num) {
                    case 1:
                        this.removeItem();
                        break;
                    case 2:
                        end = true;
                        break;
                }
            }
        }
    }


    /**
     * A helper method for the cartMenu
     * Asks the user for the id of the item they want to remove
     * and the quantity
     */
    public void removeItem() {

        System.out.print(blue + "\nPlease enter the id of the item you want to remove: " + reset);
        int id = input.nextInt();
        while (true) {
            System.out.print(blue + "\nPlease enter the quantity you want to remove: " + reset);
            int quantity = input.nextInt();
            if (quantity <= cart.getAmount(id)) {
                cart.removeItem(id, quantity);
                items.add(id, quantity);
                System.out.println("\nRemove success");
                break;
            } else {
                System.out.println(red + "\nInvalid number, please try again" + reset);
            }
        }

    }


    /**
     * Checkout menu, tells the user how many items they bought,
     * how much money they need to bring, and reminds them to
     * arrive the store before the store close at 9pm
     */
    public void checkOutMenu() {
        System.out.println("\nWelcome, your order has been created, you bought " + cart.getQuantity() + " items");
        System.out.println("You need to pay a total of $" + cart.getTotalPrice());
        System.out.println("Please remember to bring enough money and visit our store before 9pm");
        Order ord = new Order(this.name, cart.getQuantity(), cart.getTotalPrice(), "open");
        Orders.addOrder(ord);
        this.confirmMenu();
    }


    /**
     * Asks the user to confirm that they picked up their items
     */
    public void confirmMenu() {

        while (true) {
            System.out.println("\nEnter 1 to confirm that you picked up your items");
            System.out.println("\nEnter 2 to exit");
            System.out.println(red + "\nIMPORTANT NOTICE: Once you confirmed, your order will be closed");
            System.out.print(blue + "\nPlease enter your choice: " + reset);
            int num = input.nextInt();
            if (num == 1) {
                Orders.closeAll(this.name);
                break;
            } else if (num == 2) {
                System.exit(0);
                break;
            } else {
                System.out.println(red + "\nInvalid input" + reset);
            }
        }
    }


    /**
     * A helper method for the shoppingMenu
     * Adds an item into the user's shopping cart and removes that item from the inventory
     */
    public void addItem() {
        int id;
        int quantity;
        System.out.print(blue + "\nPlease inter the item id: " + reset);
        id = input.nextInt();
        while (true) {
            System.out.print(blue + "\nPlease enter amount you want: " + reset);
            quantity = input.nextInt();
            if (quantity <= items.getQuantity(id)) {
                break;
            } else {
                System.out.println(red + "\ninvalid number, Please try again");
            }
        }
        cart.addItem(items.createItem(id, quantity));
        items.reduce(id, quantity);
        System.out.println("\nitem added successfully");

    }


    /**
     * Displays the items in the store
     * Offers the user four choices
     *
     * Choice 1: add an item, which will call the addItem method
     * Choice 2: view their shopping cart, which will call the cartMenu method
     * Choice 3: checkout, which will call the checkOutMenu
     * Choice 4: exit the program, all items in shopping cart will be placed back to inventory
     */
    public void shoppingMenu() {
        
        boolean end = false;

        while (!end) {

            System.out.println(green + "\nPlease view our item list\n" + reset);
            System.out.println(items.view());
            System.out.println("Enter 1 to add item to your shopping cart");
            System.out.println("Enter 2 to view your shopping cart");
            System.out.println("Enter 3 to checkout");
            System.out.println("Enter 4 to exit");
            System.out.print(blue + "\nPlease enter your choice: " + reset);
            int num = input.nextInt();

            switch (num) {

                case 1:
                    addItem();
                    break;

                case 2:
                    cartMenu();
                    break;

                case 3:
                    if (cart.isEmpty()) {
                        System.out.println(red + "\nYou cannot checkout with empty shopping cart" + reset);
                    } else {
                        end = true;
                        this.checkOutMenu();
                    }
                    break;

                case 4:
                    items.putBack(cart.getItems());
                    end = true;
                    break;
            }
        }
    }


    public static void main(String[] args) {

        Main m = new Main();
        m.mainMenu();

    }


}
