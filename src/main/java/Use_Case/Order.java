package Use_Case;

import Entities.Customer;


/**
 * an order records a purchase by a customer
 */
public class Order{

    private final String name;
    private final int amount;
    private final double price;
    private String status;


    /**
     * constructor
     * @param name: name of customer
     * @param amount: amount of item bought
     * @param price: total value of items
     */
    public Order(String name, int amount, Double price){
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.status = "open";
    }


    /**
     * another constructor
     */
    public Order(Customer customer, int amount, Double price){
        this.name = customer.getName();
        this.amount = amount;
        this.price = price;
        this.status = "open";
    }


    /**
     * another constructor
     */
    public Order(String name, int amount, Double price, String status){
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.status = status;
    }



    /**
     * get methods
     */
    public String getCustomer() {return this.name;}


    public double getValue() {return this.price;}


    public int getTotalQuantity() {return this.amount;}


    public String getStatus() {return this.status;}


    /**
     * set the status of this order
     */
    public void setStatus(String s) {this.status = s;}


}
