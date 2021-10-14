import java.io.IOException;
import java.util.Scanner;

public class Menu {


    Scanner input = new Scanner(System.in);
    AccountManager manager = new AccountManager();
    GroceryInventory items = new GroceryInventory();
    public final String red = "\u001B[31m";
    public final String reset = "\u001B[0m";
    public final String green = "\u001B[32m";


    public void main_menu() throws IOException {

        System.out.println(green + "\nWelcome to our store, please select your choice\n" + reset);
        System.out.println("Enter 1 to create account");
        System.out.println("Enter 2 to login to account");
        System.out.println("Enter 3 to Exit");
        System.out.print("\nEnter your choice: ");
        int num = input.nextInt();

        switch (num) {

            case 1:
                this.create_account_menu();

            case 2:
                this.login_menu();

            case 3:
                System.out.println(green + "Thank you for visiting our store" + reset);
                input.close();
                System.exit(0);

        }

        System.out.println(green + "\nThank you for visiting our store" + reset);
        input.close();
        System.exit(0);
    }


    public void login_menu() throws IOException {

        String username;
        int pin;
        boolean end = false;

        while (!end) {

            System.out.print("\nPlease enter your customer username: ");
            username = input.next();
            System.out.print("\nPlease enter your PIN number: ");
            pin = input.nextInt();

            if (manager.contains(username, pin)) {

                System.out.println(green + "\nLogin success\n" + reset);
                this.customer_menu();
                end = true;

            } else {

                System.out.println(red + "\nWrong username or pin, please create one or try again\n" + reset);
                System.out.println("Enter 1 to create account");
                System.out.println("Enter 2 to try again");
                System.out.print("\nPlease enter your choice: ");
                int num = input.nextInt();

                switch (num) {

                    case 1:
                        this.create_account_menu();
                        end = true;
                    case 2:

                }

            }

        }

    }


    public void create_account_menu() throws IOException {

        String username;
        int pin;

        System.out.print("\nPlease choose your customer username: ");
        username = input.next();
        System.out.print("\nPlease choose your PIN number: ");
        pin = input.nextInt();

        Customer customer = new Customer(username, pin);

        if (manager.contains(username, pin)) {

            System.out.println("Account already exists, please login");
            this.login_menu();

        }

        manager.add_customer(customer);
        System.out.println("\nAccount created, please login");
        this.login_menu();

        System.exit(0);

    }


    public void customer_menu() {

        System.out.println("Welcome, please enter your choice\n");
        System.out.println("Enter 1 to view item list");
        System.out.println("Enter 2 to Exit");
        System.out.print("\nEnter your choice: ");
        int num = input.nextInt();

        switch (num) {

            case 1:
                System.out.println(items.view());

            case 2:
                System.out.println(green + "Thank you for visiting our store" + reset);
                System.exit(0);

        }

    }


}
