package Controllers;

import Entities.GroceryItem;
import java.io.*;
import java.util.ArrayList;


//this is a file writing class for GroceryItem's, they are stored in a file called Inventory.txt
public class GroceryInventory {

    private final String path = System.getProperty("user.dir") + File.separator + "Inventory.txt";


    //an ArrayList that store GroceryItems in Inventory.txt
    private final ArrayList<GroceryItem> items = new ArrayList<>();


    //constructor, read the file and collect all GroceryItems into an ArrayList: items
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

    //push changes in items into inventory.txt
    public void updateInventory() {
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


    //return a string representation of GroceryItems in the store
    public String view() {

        StringBuilder string = new StringBuilder();

        for (GroceryItem item : this.items) {

            string.append(item.getId()).append(" ").append(item.getName()).append(" x ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice()).append("$ each\n");

        }

        return string.toString();

    }


    //delete everything in Inventory.txt
    public void clear() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        writer.print("");
        writer.close();
    }


    //reduce the quantity of item with id by n
    public void reduce(int id, int n) {
        for (GroceryItem item: this.items) {
            if (item.getId() == id) {
                item.reduce(n);
            }
        }
        this.updateInventory();
    }


    //remove item's in items from the store
    public void remove(ArrayList<GroceryItem> items) {
        for (GroceryItem item: items) {
            this.reduce(item.getId(), item.getQuantity());
        }
        this.updateInventory();
    }


}
