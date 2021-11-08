package Entities;


//This class stores the information of an item for sale in store

public class GroceryItem {
    //A GroceryItem has four variables
    private final int id;
    private final String name;
    private final double price;
    private int quantity;


    //Constructor
    public GroceryItem(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    //Get methods
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


    //Reduce the quantity of this item by n
    public void reduce(int n) {
        this.quantity -= n;
    }


}

