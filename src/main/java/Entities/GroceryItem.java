package Entities;


//this class stores the information of an item in store for sale
public class GroceryItem {
    private final int id;
    private final String name;
    private final double price;
    private int quantity;


    //constructor
    public GroceryItem(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    //get methods
    public int getId() {
        return this.id;
    }


    public double getPrice() {
        return this.price;
    }


    public String getName() {
        return this.name;
    }


    public int getQuantity() {
        return this.quantity;
    }


    //reduce the quantity of this item by n
    public void reduce(int n) {
        this.quantity -= n;
    }


}
