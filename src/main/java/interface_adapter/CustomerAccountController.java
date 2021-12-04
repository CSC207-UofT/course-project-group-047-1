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
        for (CustomerAccount a : this.accounts) {
            if (Objects.equals(a.getUsername(), username)) {
                if (a.getPin() == pin) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a username is already been used
     *
     * @param username: is the username of the account
     * @return true if the username is already exist, false if otherwise
     */
    public boolean exists(String username) {
        for (CustomerAccount a : this.accounts) {
            if (a.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Change the color preference of a given account
     *
     * @param name:  is the username of the account
     * @param color: is the new color preference
     */
    public void changeColor(String name, String color) {
        for (CustomerAccount a : this.accounts) {
            if (a.getUsername().equals(name)) {
                a.setColor(color);
            }
        }
        this.db.update(this.accounts);
    }

    /**
     * Change the username of a given account
     *
     * @param name:    is the username of the account
     * @param newName: is the new username
     */
    public void changeUsername(String name, String newName) {
        for (CustomerAccount a : this.accounts) {
            if (a.getUsername().equals(name)) {
                a.resetUsername(newName);
            }
        }
        this.db.update(this.accounts);
    }

    /**
     * Change the pin of a given account
     *
     * @param name: is the username of the account
     * @param pin:  is the new pin
     */
    public void changePin(String name, int pin) {
        for (CustomerAccount a : this.accounts) {
            if (a.getUsername().equals(name)) {
                a.resetPin(pin);
            }
        }
        this.db.update(this.accounts);
    }

    /**
     * Add balance to a given account
     *
     * @param name: is the username of the account
     * @param n:    is the amount of balance to be added
     */
    public void addBalance(String name, double n) {
        for (CustomerAccount a : this.accounts) {
            if (a.getUsername().equals(name)) {
                a.addBal(n);
            }
        }
        this.db.update(this.accounts);
    }

    /**
     * Reduce balance from a given account
     *
     * @param name: is the username of the account
     * @param n:    is the amount of balance to be reduced
     */
    public void reduceBal(String name, double n) {
        for (CustomerAccount a : this.accounts) {
            if (a.getUsername().equals(name)) {
                a.reduceBal(n);
            }
        }
        this.db.update(this.accounts);
    }

    /**
     * Add credit to a given account
     *
     * @param name: is the username of the account
     * @param n:    is the amount of credit to be added
     */
    public void addCredit(String name, double n) {
        for (CustomerAccount a : this.accounts) {
            if (a.getUsername().equals(name)) {
                a.addCred(n);
            }
        }
        this.db.update(this.accounts);
    }


}
