package entities;


/**
 * A GroceryItem stores the information of an item in the store
 */
public class GroceryItem {
    private final int id;
    private final String name;
    private final double price;
    private int quantity;


    /**
     * Constructor
     *
     * @param id:       is the id of the item
     * @param name:     is the name of the item
     * @param price:    is the price of the item
     * @param quantity: is the quantity in stock of the item
     */
    public GroceryItem(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    /**
     * Get methods
     */
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


    /**
     * Reduces the quantity in stock of the item by n
     */
    public void reduce(int n) {
        this.quantity -= n;
    }


    /**
     * Adds the quantity in stock of the item by n
     */
    public void add(int n) {this.quantity += n;}
}
