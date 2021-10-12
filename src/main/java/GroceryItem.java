public class GroceryItem{
    private String name;
    private double price;
    private int quantity;

    public GroceryItems (String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void removeQuantity(int n) {
        this.quantity_in_stock -= n;
    }
}
