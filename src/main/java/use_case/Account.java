package use_case;

import entities.Customer;


/**
 * An account stores the username and pin of a customer's account
 */
public class Account {


    private final String username;
    private final int pin;


    /**
     * Constructor
     *
     * @param username: the username of the account
     * @param pin:      the password of the account
     */
    public Account(String username, int pin) {
        this.username = username;
        this.pin = pin;
    }


    /**
     * Another constructor
     */
    public Account(Customer customer, int pin) {
        this.username = customer.getName();
        this.pin = pin;
    }


    /**
     * Returns the username of the account
     */
    public String getUsername() {return this.username;}


    /**
     * Returns the pin of the account
     */
    public int getPin() {return this.pin;}


}
