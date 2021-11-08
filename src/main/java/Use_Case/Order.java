package Use_Case;
import Entities.Customer;


//an Order records a purchase by a customer
public class Order{

    private final String name;
    private final int amount;
    private final double price;


    //constructor
    public Order(String name, int amount, Double price){
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    //another constructor
    public Order(Customer customer, int amount, Double price){
        this.name = customer.getName();
        this.amount = amount;
        this.price = price;
    }


    //get methods
    public String getCustomer() {return this.name;}


    public double getValue() {return this.price;}


    public int getTotalQuantity() {return this.amount;}


}
