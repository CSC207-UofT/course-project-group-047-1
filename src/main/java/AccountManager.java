import java.util.ArrayList;


public class AccountManager{


    private final ArrayList<Customer> customers;


    public AccountManager() {

        customers = new ArrayList<> ();

    }


    public void add_customer(Customer customer) {

        this.customers.add(customer);

    }


    public boolean contains(String username, int pin) {

        for (Customer customer : this.customers) {

            if (customer.getUsername().equals(username)) {

                if (customer.getPin() == pin) {return true;}

            }

        }
        return false;

    }


}

