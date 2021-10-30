package Use_Case;


import Entities.GroceryItem;

import java.util.ArrayList;

public class GroceryInventory {


    private final ArrayList<GroceryItem> items;


    public GroceryInventory() {

        GroceryItem apple = new GroceryItem("apple", 3, 10);
        GroceryItem watermelon = new GroceryItem("watermelon", 10, 5 );
        GroceryItem laptop = new GroceryItem("Laptop", 1000, 1);
        this.items = new ArrayList<>();
        this.items.add(apple);
        this.items.add(watermelon);
        this.items.add(laptop);

    }


    public String view() {

        StringBuilder string = new StringBuilder();

        for (GroceryItem item : this.items) {

            string.append(item.getName()).append(" x ").append(item.getQuantity()).append(", Price: ").append(item.getPrice()).append("$ each\n");

        }

        return string.toString();

    }

}
