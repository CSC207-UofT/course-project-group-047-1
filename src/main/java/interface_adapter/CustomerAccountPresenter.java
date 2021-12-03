package interface_adapter;

import use_case.CustomerAccount;
import use_case.CustomerDataAccess;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class provides a string presentation of customer account infos
 */
public class CustomerAccountPresenter implements Iterable<CustomerAccount> {

    CustomerDataAccess db;
    ArrayList<CustomerAccount> accounts;

    /**
     * Constructor
     */
    public CustomerAccountPresenter(CustomerDataAccess db) {
        this.db = db;
        this.accounts = db.read();
    }

    /**
     * Updates the list of all accounts
     */
    private void update() {
        this.accounts = db.read();
    }


    /**
     * Returns a string representation of the username of a given account
     *
     * @param name: is the username of the account
     * @return a string representation of the username if the account exists,
     * return an empty string if otherwise
     */
    public String viewName(String name) {
        this.update();

        for (CustomerAccount a : accounts) {
            if (a.getUsername().equals(name)) {
                return (a.getUsername());
            }
        }
        return "";
    }

    /**
     * Returns a string representation of the pin of a given account
     *
     * @param name: is the username of the account
     * @return a string representation of the pin if the account exists,
     * return 0 if otherwise
     */
    public int viewPin(String name) {
        this.update();

        for (CustomerAccount a : accounts) {
            if (a.getUsername().equals(name)) {
                return a.getPin();
            }
        }
        return 0;
    }


    /**
     * Returns a string representation of the balance of a given account
     *
     * @param name: is the username of the account
     * @return a string representation of the balance if the account exists,
     * return 0 if otherwise
     */
    public double viewBal(String name) {
        this.update();

        for (CustomerAccount a : accounts) {
            if (a.getUsername().equals(name)) {
                return a.getBal();
            }
        }
        return 0;
    }


    /**
     * Returns a string representation of the credit of a given account
     *
     * @param name: is the username of the account
     * @return a string representation of the credit if the account exists,
     * return 0 if otherwise
     */
    public double viewCred(String name) {
        this.update();

        for (CustomerAccount a : accounts) {
            if (a.getUsername().equals(name)) {
                return a.getCred();
            }
        }
        return 0;
    }


    /**
     * Returns a string representation of the color preference of a given account
     *
     * @param name: is the username of the account
     * @return a string representation of the color preference if the account exists,
     * return an empty string if otherwise
     */
    public String viewColor(String name) {
        this.update();

        for (CustomerAccount a : accounts) {
            if (a.getUsername().equals(name)) {
                return a.getColor();
            }
        }
        return "";
    }


    /**
     * Returns an iterator that iterates through all customer accounts
     */
    @Override
    public Iterator<CustomerAccount> iterator() {
        return new CustomerAccountIterator();
    }


    /**
     * The iterator class for CustomerAccount
     */
    private class CustomerAccountIterator implements Iterator<CustomerAccount> {

        private int customer = 0;

        /**
         * Check if the iterator has a next element
         *
         * @return true if the iterator has a next element, false if otherwise
         */
        @Override
        public boolean hasNext() {
            return this.customer < db.read().size();
        }


        /**
         * Returns the next customer account in the list
         */
        @Override
        public CustomerAccount next() {
            int curr_customer = this.customer;
            this.customer += 1;
            return db.read().get(curr_customer);
        }
    }
}
