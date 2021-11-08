package Controllers;

//This is a file writing class for GroceryItem's, they are stored in a file called Inventory.txt

import Entities.Customer;
import Entities.GroceryItem;

import java.io.*;
import java.util.ArrayList;


public class GroceryInventory {

    String path = System.getProperty("user.dir") + File.separator + "Inventory.txt";

    //An ArrayList that store GroceryItems in Inventory.txt
    private final ArrayList<GroceryItem> items = new ArrayList<>();

    //Constructor
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

    //Push changes in items into inventory.txt
    public void UpdateInventory() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            this.clear();
            for (GroceryItem item : this.items) {
                String id = Integer.toString(item.getId());
                writer.write(id);
                writer.newLine();
                writer.write(item.getName());
                writer.newLine();
                writer.write(String.valueOf(item.getPrice()));
                writer.newLine();
                String q = Integer.toString(item.getQuantity());
                writer.write(q);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Return a string representation of GroceryItems in the store
    public String view() {

        StringBuilder string = new StringBuilder();

        for (GroceryItem item : this.items) {

            string.append(item.getId()).append(" ").append(item.getName()).append(" x ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice()).append("$ each\n");

        }

        return string.toString();

    }


    //Delete everything in Inventory.txt
    public void clear() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        writer.print("");
        writer.close();
    }


    //Reduce the quantity of item with id by n
    public void Reduce(int id, int n) {
        for (GroceryItem item: this.items) {
            if (item.getId() == id) {
                item.reduce(n);
            }
        }
        this.UpdateInventory();
    }


    //Remove item's in items from the store
    public void Remove(ArrayList<GroceryItem> items) {
        for (GroceryItem item: items) {
            this.Reduce(item.getId(), item.getQuantity());
        }
        this.UpdateInventory();
    }


}
