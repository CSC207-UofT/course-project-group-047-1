package use_case;

/**
 * An order records a purchase by a customer
 */
public class Order {

    private String name;
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
     * Constructor
     *
     * @param name:   is the name of the customer who placed the order
     * @param amount: is the total quantity of items in the order
     * @param price:  is the total price of items in the order
     * @param status: is the status of the order
     */
    public Order(String name, int amount, Double price, String status) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.status = status;
    }


    /**
     * Get the customer's name.
     */
    public String getCustomer() {return this.name;}


    /**
     * Get the total price of the order.
     */
    public double getValue() {return this.price;}


    /**
     * Get the total number of items in the order.
     */
    public int getTotalQuantity() {return this.amount;}


    /**
     * Get the status of the order.
     */
    public String getStatus() {return this.status;}


    /**
     * Set the status of the order
     * @param s: the status of the order.
     */
    public void setStatus(String s) {this.status = s;}


    /**
     * Return the information of this order
     */
    public String returnInfo(){
        return "Status: " + this.getStatus() + "\nTotal number of items: " + this.getTotalQuantity()
                + "\nTotal price: " + this.getValue() + "\n\n";
    }


    /**
     * Reset the username of this order
     * @param new_name: is the new name of the customer for this order
     */
    public void resetUsername(String new_name) {this.name = new_name;}

}
