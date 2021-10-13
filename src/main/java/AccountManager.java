import java.util.ArrayList;

public class AccountManager{

    private ArrayList<Customer> customers;


    public AccountManager() {}


    public void add_customer(Customer customer) {
        this.customers.add(customer);
    }


    public boolean exists(String username) {
        for (Customer customer : this.customers) {
            if (customer.getUsername().equals(username)) {return true;}
        }
        return false;
    }


    public boolean login(String username, int pin) {
        for (Customer customer : this.customers) {
            if (customer.getUsername().equals(username)) {
                if (customer.getpin() == pin) {return true;}
            }
        }
        return false;
    }

    public boolean is_customer(Customer customer) {
        if (this.customers.contains(customer)) {return true;}

        return false;
    }

}

