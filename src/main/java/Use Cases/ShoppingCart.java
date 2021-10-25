import java.util.ArrayList;


public class ShoppingCart {


    private final ArrayList<GroceryItem> items;


    public ShoppingCart() {

        this.items = new ArrayList<>();

    }

    // for future use

    public void AddItem(GroceryItem item) {

        this.items.add(item);

    }

    // for future use
    public void RemoveItem(int index) {

        this.items.remove(index);

    }

    // for future use
    public double getTotalPrice() {

        int total = 0;

        for (GroceryItem i: this.items) {

            total += (i.getPrice())*(i.getQuantity());

        }

        return total;

    }


}
