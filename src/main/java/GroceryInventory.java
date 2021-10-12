import java.util.ArrayList;

public class GroceryInventory {

    private ArrayList<GroceryItem> items;


    public GroceryInventory() {
        GroceryItem apple = new GroceryItem("apple", 3, 10);
        GroceryItem watermelon = new GroceryItem("watermelon", 10, 5 );
        GroceryItem laptop = new GroceryItem("Laptop", 1000, 1);
        this.items = new ArrayList<GroceryItem>();
        this.items.add(apple);
        this.items.add(watermelon);
        this.items.add(laptop);
    }
}
