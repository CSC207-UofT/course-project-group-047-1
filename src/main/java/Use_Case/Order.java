package Use_Case;

//An Order records a purchase buy a customer and the GroceryItems they bought


import Entities.Customer;


public class Order{

    private final String name;
    private final int amount;
    private final double price;


    //Constructor
    public Order(String name, int amount, Double price){
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    //Another constructor
    public Order(Customer customer, int amount, Double price){
        this.name = customer.getName();
        this.amount = amount;
        this.price = price;
    }


    //Get methods
    public String getCustomer() {return this.name;}


    public double getValue() {return this.price;}


    public int getTotalQuantity() {return this.amount;}


}
