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


    public void remove_item(GroceryItem item, int quantity) {
        int index = this.items.indexOf(item);
        int old_quantity = item.getQuantity();
        GroceryItem new_item = new GroceryItem(item.getName(), item.getPrice(), old_quantity - quantity);
        this.items.set(index, new_item);
    }
}
