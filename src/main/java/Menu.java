import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);
    AccountManager manager = new AccountManager();


    public void login_menu() throws IOException {

        String username;
        String address;
        int pin;
        boolean end = false;

        System.out.print("\nPlease enter your customer username: ");
        username = input.next();
        System.out.print("\nPlease enter your PIN number: ");
        pin = input.nextInt();

        if (manager.contains(username, pin)) {
            System.out.println("login success");
        }



    }


    public void create_account_menu() throws IOException {

        String username;
        String address;
        int pin;

        System.out.print("\nPlease enter your customer username: ");
        username = input.next();
        System.out.print("\nPlease enter your PIN number: ");
        pin = input.nextInt();

        Customer customer = new Customer(username, pin);

        if (manager.contains(username, pin)) {
            System.out.println("Account already exists, please login");
            this.login_menu();
        }

        manager.add_customer(customer);
        System.out.println("Account created, please login");
        this.login_menu();

        System.exit(0);


    }


    public void customer_menu() {
        System.out.println("Welcome, please enter your choice\n");

    }


    public void main_menu() {

    }

}
