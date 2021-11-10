package Use_Case;

import Entities.Customer;


/**
 * an account stores the username and the pin of an account registered
 */
public class Account {


    private final String username;
    private final int pin;


    /**
     * constructor
     * @param username: String
     * @param pin: int
     */
    public Account(String username, int pin){
        this.username = username;
        this.pin = pin;
    }


    /**
     * another constructor
     */
    public Account(Customer customer, int pin){
        this.username = customer.getName();
        this.pin = pin;
    }


    /**
     * @return: return the username of this account
     */
    public String getUsername(){return this.username;}


    /**
     * return the pin of this account
     * @return: int
     */
    public int getPin(){return this.pin;}


}


