public class GroceryItem{

    private String name;
    private double price;
    private int quantity;

    public GroceryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {return this.price;}


    public String getName() {return this.name;}


    public int getQuantity() {return this.quantity;}

    public void reduce(int n) {this.quantity -= n;}

}
