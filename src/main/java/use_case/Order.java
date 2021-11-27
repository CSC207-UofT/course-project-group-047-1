package use_case;


/**
 * An order records a purchase by a customer
 */
public class Order {

    private final String name;
    private final int amount;
    private final double price;
    private String status;


    /**
     * Constructor
     *
     * @param name:   is the name of the customer who placed the order
     * @param amount: is the total quantity of items in the order
     * @param price:  is the total price of items in the order
     */
    public Order(String name, int amount, Double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.status = "open";
    }


    /**
     * Another constructor
     */
    public Order(String name, int amount, Double price, String status) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.status = status;
    }


    /**
     * Get methods
     */
    public String getCustomer() {return this.name;}


    public double getValue() {return this.price;}


    public int getTotalQuantity() {return this.amount;}


    public String getStatus() {return this.status;}


    /**
     * Set the status of the order
     */
    public void setStatus(String s) {this.status = s;}


}
