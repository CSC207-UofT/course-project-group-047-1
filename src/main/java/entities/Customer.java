package entities;


/**
 * A customer is a user of the program
 */
public class Customer{


    private String name;


    /**
     * Constructor
     * @param name: is the name of the customer
     */
    public Customer (String name){this.name = name;}


    /**
     * Returns the name of the customer
     */
    public String getName(){return this.name;}


    /**
     * Change the name of the customer
     * @param name: the new name for this customer
     */
    public void changeName(String name) {this.name = name;}
}
