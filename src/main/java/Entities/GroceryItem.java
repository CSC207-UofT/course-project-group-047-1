package Entities;


import External_Interface.Discounter;
import External_Interface.NoDiscounter;

public class GroceryItem{
    // a GroceryItem has five variables
    private final int id;
    private final String name;
    private final double price;
    private int quantity;
    private Discounter discountStrategy;


    //constructor
    public GroceryItem(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        setDiscounter(new NoDiscounter());

    }


    //get methods
    public int getId() {return this.id;}


    public double getPrice() {return this.price;}


    public String getName() {return this.name;}


    public int getQuantity() {return this.quantity;}


    public void reduce(int n) {this.quantity -= n;}


    public void reduceAmount(int n) {
        //reduce quantity of this item by n
        this.quantity -= n;
    }

    /**
     * Sets the discounter for this item.
     */
    public void setDiscounter(Discounter discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Apply the discounter for this item.
     */
    public Discounter GetDiscountStrategy() {
        return this.discountStrategy;
    }
}
