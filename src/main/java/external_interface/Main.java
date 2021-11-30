package external_interface;

import interface_adapter.*;
import use_case.*;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


/**
 * This class accepts user input and convert them into system output, and it is the only class that should be run.
 */
public class Main {


    private final Scanner input = new Scanner(System.in);
    private ShoppingCart cart;
    private String name;

    private final CustomerAccountController accounts = new CustomerAccountController(new CustomerAccountAccess());
    private final InventoryController items = new InventoryController(new InventoryAccess());
    private final OrderController orders = new OrderController(new OrderAccess());

    private final CustomerAccountPresenter accountPresenter = new CustomerAccountPresenter(new CustomerAccountAccess());
    private final OrderPresenter orderPresenter = new OrderPresenter(new OrderAccess());
    private final InventoryPresenter inventoryPresenter = new InventoryPresenter(new InventoryAccess());

    public final String red = "\u001B[31m";
    public final String reset = "\u001B[0m";
    public final String green = "\u001B[32m";
    public final String blue = "\u001B[34m";
    public final String yellow = "\u001B[33m";

    private String wel = green;
    private String warn = red;
    private String in = blue;
    private String ord = yellow;


    /**
     * A welcome menu that provides three choices for the users
     *
     * Choice 1: create an account, which will call the createAccountMenu method
     * Choice 2: login to an account, which will call the loginMenu method
     * Choice 3: exit, will exit the program
     */
    private void mainMenu() {

        boolean end = false;
        System.out.println(wel + "Welcome main menu, please select your choice\n" + reset);

        while(!end) {

            try {
                System.out.println("Enter 1 to create account");
                System.out.println("Enter 2 to login to account");
                System.out.println("Enter 3 to Exit");
                System.out.print(blue + "\nEnter your choice: " + reset);
                int num = input.nextInt();
                input.nextLine();

                switch (num) {

                    case 1:
                        this.createAccountMenu();
                        end = true;
                        break;

                    case 2:
                        this.loginMenu();
                        end = true;
                        break;

                    case 3:
                        end = true;
                        break;

                    default:
                        System.out.println(warn + "\nInvalid input\n" + reset);
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println(warn + "\nInvalid input\n" + reset);
                input.next();
            }

        }

        System.out.println(wel + "\nThank you for visiting our store" + reset);
        input.close();
        System.exit(0);
    }


    /**
     * Asks the user for their username and pin, calls a method in the CustomerAccountController
     * that checks the credentials to determine if an account exists. If so, then
     * calls the customerMenu. If not, asks the user to try again.
     * If an account has an open order, then calls the confirmMenu.
     */
    private void loginMenu() {

        String username;
        int pin;
        boolean end = false;

        System.out.println();
        System.out.println(wel + "Welcome to login page" + reset);

        while (!end) {

            try {
                System.out.print(in + "\nPlease enter your username: " + reset);
                username = input.nextLine();
                System.out.print(in + "\nPlease enter your pin number: " + reset);
                pin = input.nextInt();
                input.nextLine();

                if (this.accounts.check(username, pin)) {

                    this.name = username;
                    this.setColor();

                    System.out.println("\nLogin success");

                    if (this.orders.haveOpenOrder(name)) {
                        System.out.println(warn + "\nYou have an unfinished order, please complete this order first"
                                + reset);
                        this.confirmMenu();
                    } else {
                        this.customerMenu();
                    }
                    end = true;

                } else {
                    System.out.println(warn + "\nWrong username or pin" + reset);
                }

            } catch (InputMismatchException e) {
                System.out.println(warn + "\nInvalid input\n" + reset);
                input.nextLine();
            }

        }

    }


    /**
     * Asks the user to set up an account by providing a username and pin,
     * then calls the loginMenu method
     */
    private void createAccountMenu() {

        String username;
        int pin;
        boolean end = false;

        System.out.println();
        System.out.println(wel + "Welcome to create account page" + reset);

        while (!end) {

            try {
                System.out.print(in + "\nPlease choose your customer username: " + reset);
                username = input.nextLine();
                System.out.print(in + "\nPlease choose your PIN number: " + reset);
                pin = input.nextInt();
                input.nextLine();

                if (this.accounts.exists(username)) {
                    System.out.println(warn + "\nUsername already exists" + reset);
                } else {
                    CustomerAccount a = new CustomerAccount(username, pin, 0.0, 0.0, "default");
                    this.accounts.addAccount(a);
                    System.out.println("\nAccount created, please login");
                    this.loginMenu();
                    end = true;
                }

            } catch (InputMismatchException e) {
                System.out.println(warn + "\nInvalid input\n" + reset);
                input.nextLine();
            }
        }

    }


    /**
     * Provides four choices for the user
     * choice 1: start shopping
     * choice 2: account setting
     * choice 3: view order history
     * choice 4: back to main menu
     */
    private void customerMenu() {

        System.out.println(wel + "\nWelcome to customer menu, please enter your choice" + reset);

        boolean end = false;
        while(!end) {
            try {
                System.out.println();
                System.out.println("Enter 1 to start shopping");
                System.out.println("Enter 2 to manage your account");
                System.out.println("Enter 3 to view order history");
                System.out.println("Enter 4 to go back to main menu");

                System.out.print(in + "\nEnter your choice: " + reset);
                int num = input.nextInt();
                input.nextLine();
                System.out.println();

                switch (num) {
                    case 1:
                        if(this.accountPresenter.viewBal(this.name) >= 0) {
                            this.cart = new ShoppingCart();
                            this.shoppingMenu();
                        } else {
                            System.out.println(warn + "you do not have enough balance" + reset);
                        }
                        break;

                    case 2:
                        this.accountSetting();
                        break;

                    case 3:
                        if (this.orders.haveOrder(this.name)) {
                            String str = this.orderPresenter.view(this.name);
                            System.out.println("Below is your history of orders\n");
                            System.out.print(this.ord + str + reset);
                        } else {
                            System.out.println(warn + "you do not have any order history" + reset);
                        }
                        break;

                    case 4:
                        end = true;
                        this.mainMenu();
                        break;

                    default:
                        System.out.println(warn + "\nInvalid input\n" + reset);
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println(warn + "\nInvalid input\n" + reset);
                input.nextLine();
            }
        }
    }


    private void accountSetting() {
        System.out.println(wel + "\nWelcome, below is your current information" + reset);
        boolean end = false;

        while (!end) {

            try {
                System.out.println("\nyour current username: " + this.accountPresenter.viewName(this.name));
                System.out.println("your current pin: " + this.accountPresenter.viewPin(this.name));
                System.out.println("your current color setting: " + this.accountPresenter.viewColor(this.name));
                System.out.println("your current credit: " + this.accountPresenter.viewCred(this.name));
                System.out.println("your current balance: " + this.accountPresenter.viewBal(this.name) + "\n");

                System.out.println("Enter 1 to change your username");
                System.out.println("Enter 2 to change your pin");
                System.out.println("Enter 3 to add balance");
                System.out.println("Enter 4 to change your color setting");
                System.out.println("Enter 5 to go back");

                System.out.print(in + "\nPlease enter your choice: " + reset);
                int n = input.nextInt();
                switch (n) {

                    case 5:
                        end = true;
                        break;

                    case 1:
                        this.changeName();
                        break;

                    case 2:
                        this.changePin();
                        break;

                    case 3:
                        this.addBalance();
                        break;

                    case 4:
                        this.changeColor();
                        break;

                    default:
                        System.out.println(warn + "\nInvalid input\n" + reset);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(warn + "\nInvalid input\n" + reset);
                input.next();
            }
        }

    }


    private void changeName() {
        System.out.print(in + "\nEnter the new username you want: " + reset);
        String n = input.next();
        if (this.accounts.exists(n)) {
            System.out.print(warn + "\nusername already exists\n" + reset);
        } else {
            this.accounts.changeUsername(this.name, n);
            this.orders.changeName(this.name, n);
            this.name = n;
            System.out.println("\nName change success");
        }
    }


    private void changeColor() {
        System.out.println("\nEnter 1 to set default color");
        System.out.println("Enter 2 to set all black color");
        System.out.println("Enter 3 to set invert color");
        System.out.print(in + "\nEnter your choice: " + reset);
        int n = input.nextInt();
        switch (n) {
            case 1:
                this.accounts.changeColor(this.name, "default");
                this.setColor();
                System.out.println("\nColor change success");
                break;

            case 2:
                this.accounts.changeColor(this.name, "all_black");
                this.setColor();
                System.out.println("\nColor change success");
                break;

            case 3:
                this.accounts.changeColor(this.name, "invert");
                this.setColor();
                System.out.println("\nColor change success");
                break;

            default:
                System.out.println(warn + "\nInvalid input\n" + reset);
                break;

        }

    }


    private void addBalance() {
        System.out.print(in + "\nEnter the amount you want to add: " + reset);
        double n = input.nextDouble();
        if (0 < n) {
            this.accounts.addBalance(this.name, n);
            System.out.println("\nAdd success");
        } else {
            System.out.println(warn + "\nInvalid input\n" + reset);
        }
    }


    private void changePin() {
        System.out.print(in + "\nEnter the new pin you want: " + reset);
        int n = input.nextInt();
        this.accounts.changePin(this.name, n);
        System.out.println("\nPin change success");

    }


    private void setColor() {
        String color = this.accountPresenter.viewColor(this.name);
        if (Objects.equals(color, "all_black")) {
            warn = "";
            in = "";
            wel = "";
            ord = "";
        } else if(Objects.equals(color, "invert")) {
            warn = green;
            in = yellow;
            wel = red;
            ord = blue;
        } else {
            warn = red;
            in = blue;
            wel = green;
            ord = yellow;
        }
    }


    /**
     * Displays the items in the user's shopping cart
     * Offers user two choices
     *
     * Choice 1: remove items from their shopping cart
     * Choice 2: go back to the shoppingMenu
     */
    private void cartMenu() {

        boolean end = false;

        while (!end) {

            try {
                if (cart.isEmpty()) {
                    System.out.println(warn + "\nyou have nothing in your cart, please continue shopping or go back" +
                            "\n" + reset);
                    end = true;
                } else {
                    System.out.println(wel + "\nBelow is what you have in your shopping cart\n" + reset);
                    System.out.println(this.cart.view());
                    System.out.println("Enter 1 to remove items");
                    System.out.println("Enter 2 to go back shopping");
                    System.out.print(in + "\nPlease enter your choice: " + reset);
                    int num = input.nextInt();

                    switch (num) {

                        case 1:
                            this.removeItem();
                            break;

                        case 2:
                            end = true;
                            break;

                        default:
                            System.out.println(warn + "\nInvalid input\n" + reset);
                            break;
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println(warn + "\nInvalid input\n" + reset);
                input.next();
            }
        }

    }


    /**
     * A helper method for the cartMenu
     * Asks the user for the id of the item they want to remove
     * and the quantity
     */
    private void removeItem() {

        System.out.print(in + "\nPlease enter the id of the item you want to remove: " + reset);
        int id = input.nextInt();
        if (this.cart.exists(id)) {
            System.out.print(in + "\nPlease enter the quantity you want to remove: " + reset);
            int quantity = input.nextInt();
            if (quantity <= cart.getAmount(id) && 0 < quantity) {
                cart.removeItem(id, quantity);
                items.add(id, quantity);
                System.out.println("\nRemove success\n");
            } else {System.out.println(warn + "\nInvalid input\n" + reset);}

        } else {System.out.println(warn + "\nInvalid input\n" + reset);}


    }


    /**
     * Checkout menu, tells the user how many items they bought,
     * how much money they need to bring, and reminds them to
     * arrive the store before the store close at 9pm
     */
    private void checkOutMenu() {
        System.out.println("\nyour order has been created, you bought " + cart.getQuantity() + " items");
        System.out.println("A total of $" + cart.getTotalPrice() +" has been deducted from your account");
        System.out.println("Please remember to visit our store before 9pm");
        Order ord = new Order(this.name, cart.getQuantity(), cart.getTotalPrice());
        this.orders.addOrder(ord);
        this.accounts.reduceBal(this.name, this.cart.getTotalPrice());
        this.accounts.addCredit(this.name, this.cart.getTotalPrice());

        this.confirmMenu();
    }


    /**
     * Asks the user to confirm that they picked up their items
     */
    private void confirmMenu() {

        boolean end = false;

        while (!end) {

            try {
                System.out.println("\nEnter 1 to confirm that you picked up your items");
                System.out.println("Enter 2 to exit");
                System.out.println(warn + "\nIMPORTANT NOTICE: Once you confirmed, your order will be closed" + reset);
                System.out.print(in + "\nPlease enter your choice: " + reset);
                int num = input.nextInt();
                if (num == 1) {
                    this.orders.closeAll(this.name);
                    this.accounts.addCredit(this.name, 1.0);
                    System.out.println(wel + "\nThank you for your order" + reset);
                    end = true;
                } else if (num == 2) {
                    System.exit(0);
                    end = true;
                } else {
                    System.out.println(warn + "\nInvalid input" + reset);
                }
            } catch (InputMismatchException e) {
                System.out.println(warn + "\nInvalid input\n" + reset);
                input.next();
            }
        }


    }


    /**
     * A helper method for the shoppingMenu
     * Adds an item into the user's shopping cart and removes that item from the inventory
     */
    private void addItem() {

        System.out.print(in + "\nPlease enter the id of the item you want to add: " + reset);
        int id = input.nextInt();
        if (this.items.exists(id)) {
            System.out.print(in + "\nPlease enter the quantity you want to add: " + reset);
            int quantity = input.nextInt();
            if (quantity <= this.items.getQuantity(id) && 0 < quantity) {
                this.cart.addItem(this.items.createItem(id, quantity));
                this.items.reduce(id, quantity);
                System.out.println("\nAdd success\n");
            } else {
                System.out.println(warn + "\nInvalid input\n" + reset);
            }
        } else {System.out.println(warn + "\nInvalid input\n" + reset);}


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
    private void shoppingMenu() {
        
        boolean end = false;

        while (!end) {

            try {
                System.out.println(wel + "Please view our item list\n" + reset);
                System.out.println(this.inventoryPresenter.view());
                System.out.println("Enter 1 to add item to your shopping cart");
                System.out.println("Enter 2 to view your shopping cart");
                System.out.println("Enter 3 to checkout");
                System.out.println("Enter 4 to go back");
                System.out.print(in + "\nPlease enter your choice: " + reset);
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
                            System.out.println(warn + "\nYou cannot checkout with empty shopping cart\n" + reset);
                        } else {
                            end = true;
                            this.checkOutMenu();
                        }
                        break;

                    case 4:
                        items.putBack(cart.getItems());
                        end = true;
                        break;

                    default:
                        System.out.println(warn + "\nInvalid input\n" + reset);
                        break;

                }

            } catch (InputMismatchException e) {
                System.out.println(warn + "\nInvalid input\n" + reset);
                input.next();
            }
        }

    }


    public static void main(String[] args) {

        Main m = new Main();
        m.mainMenu();

    }


}
