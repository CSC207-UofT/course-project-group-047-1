import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<GroceryItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<GroceryItem>();
    }

    public void AddItem(GroceryItem item) {
        this.items.add(item);
    }

    public void RemoveItem(int index) {
        this.items.remove(index);
    }

    public double getTotalPrice() {
        int total = 0;
        for (GroceryItem i: this.items) {
            total += (i.getPrice())*(i.getQuantity());
        }
        return total;
    }


}
