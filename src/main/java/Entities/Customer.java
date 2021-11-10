package Entities;


/**
 * a customer is a user of the program
 */
public class Customer{


    private String name;


    /**
     * constructor
     * @param name: String
     */
    public Customer (String name){this.name = name;}


    /**
     * @return: String
     */
    public String getName(){return this.name;}


    /**
     * change the name of the customer
     * @param name: String: new name
     */
    public void changeName(String name) {this.name = name;}
}