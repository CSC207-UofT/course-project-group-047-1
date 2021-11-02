package Entities;


public class GroceryItem{

    private final int id;
    private final String name;
    private final double price;
    private int quantity;


    public GroceryItem(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public int getId() {return this.id;}


    public double getPrice() {return this.price;}


    public String getName() {return this.name;}


    public int getQuantity() {return this.quantity;}


    public void reduce(int n) {this.quantity -= n;}


}
