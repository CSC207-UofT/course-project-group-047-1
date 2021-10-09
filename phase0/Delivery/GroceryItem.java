public class GroceryItem{
    private String item_name;
    private double price;
    private int quantity_in_stock;

    public GroceryItem (String name, int price, int quantity) {
        this.item_name = name;
        this.price = price;
        this.quantity_in_stock = quantity;
    }
}
