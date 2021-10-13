import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);
    AccountManager manager = new AccountManager();


    public void login_menu() {

        String username;
        String address;
        int pin;
        boolean end = false;

        while (!end) {
            try {
                System.out.print("\nPlease enter your customer username: ");
                username = input.next();
                System.out.print("\nPlease enter your PIN number: ");
                pin = input.nextInt();
                System.out.print("\nPlease enter your address");
                address = input.next();

                Customer user = new Customer(username, pin, address);
                if (manager.is_customer(user)) {
                    customer_menu();
                    end = true;
                }

                if (!end) {
                    System.out.println("\ninvalid username or Pin Number");
                }

            } catch (
                    InputMismatchException e) {
                System.out.println("\nInvalid input");
            }
        }
    }


    public void customer_menu() {
        System.out.println("Welcome, please enter your choice\n");

    }


    public void main_menu() {

    }

}
