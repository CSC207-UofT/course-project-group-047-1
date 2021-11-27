package interface_adapter;

import use_case.CustomerAccount;
import use_case.CustomerDataAccess;


import java.util.ArrayList;
import java.util.Objects;


/**
 * This class manage all accounts registered in the store
 */
public class CustomerAccountController {

    private final CustomerDataAccess db;
    private final ArrayList<CustomerAccount> accounts;


    /**
     * Constructor
     */
    public CustomerAccountController(CustomerDataAccess db) {
        this.db = db;
        this.accounts = db.read();
    }


    /**
     * Adds an CustomerAccount
     *
     * @param customerAccount: is the CustomerAccount to be added
     */
    public void addAccount(CustomerAccount customerAccount) {
        this.accounts.add(customerAccount);
        this.db.update(this.accounts);
    }


    /**
     * Checks credentials
     *
     * @param username: is the username of the account
     * @param pin:      is the pin of the account
     * @return true if pin is correct, false if otherwise
     */
    public boolean check(String username, int pin) {
        for (CustomerAccount a: this.accounts) {
            if (Objects.equals(a.getUsername(), username)) {
                if (a.getPin() == pin) {return true;}
            }
        }
        return false;
    }


    public boolean exists(String username) {
        for (CustomerAccount a : this.accounts){
            if (a.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }


    public void changeColor(String name, String color) {
        for (CustomerAccount a : this.accounts) {
            if (a.getUsername().equals(name)) {
                a.setColor(color);
            }
        }
    }
}
