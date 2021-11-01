package Use_Case;


import Entities.GroceryItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GroceryInventory {

    private final ArrayList<GroceryItem> items = new ArrayList<>();

    public GroceryInventory() {

        String path = System.getProperty("user.dir") + File.separator + "Inventory.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int price = Integer.parseInt(reader.readLine());
                int quantity = Integer.parseInt(reader.readLine());
                GroceryItem g = new GroceryItem(line, price, quantity);
                this.items.add(g);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<GroceryItem> getItems() {
        return items;
    }
}
