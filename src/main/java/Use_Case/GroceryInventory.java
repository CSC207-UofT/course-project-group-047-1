package Use_Case;


import Entities.GroceryItem;

import java.io.*;
import java.util.ArrayList;

public class GroceryInventory {

    String path = System.getProperty("user.dir") + File.separator + "Inventory.txt";
    private final ArrayList<GroceryItem> items = new ArrayList<>();

    public GroceryInventory() {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name = reader.readLine();
                double price = Double.parseDouble(reader.readLine());
                int quantity = Integer.parseInt(reader.readLine());
                GroceryItem g = new GroceryItem(Integer.parseInt(line), name, price, quantity);
                this.items.add(g);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void UpdateInventory() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (GroceryItem item : this.items) {
                writer.write(item.getId());
                writer.newLine();
                writer.write(item.getName());
                writer.newLine();
                writer.write(String.valueOf(item.getPrice()));
                writer.newLine();
                writer.write(item.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<GroceryItem> getItems() {
        return items;
    }
}
