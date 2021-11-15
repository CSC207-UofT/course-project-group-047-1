package controllers;

import entities.GroceryItem;

import java.io.*;
import java.util.ArrayList;


/**
 * This is a file writing class that stores all grocery items in the store into Inventory.txt
 */
public class GroceryInventory {

    private final String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
            "main" + File.separator + "java" + File.separator + "files" + File.separator + "inventory.txt";
    private final ArrayList<GroceryItem> items = new ArrayList<>();


    /**
     * Constructor
     * Reads the file and collects all items into an ArrayList
     */
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


    /**
     * Push changes in the ArrayList into the Inventory.txt file
     */
    public void updateInventory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
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


    /**
     * @return a string representation of GroceryItems in the store
     */
    public String view() {

        StringBuilder string = new StringBuilder();

        for (GroceryItem item : this.items) {

            string.append(item.getId()).append(" ").append(item.getName()).append(" x ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice()).append("$ each\n");

        }

        return string.toString();

    }


    /**
     * Wipes everything in the file
     */
    public void clear() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        writer.print("");
        writer.close();
    }


    /**
     * Reduces the quantity in stock of an item with id by n
     *
     * @param id: is the id of the item to be reduced
     * @param n:  is the quantity reduced of the item
     */
    public void reduce(int id, int n) {
        for (GroceryItem item : this.items) {
            if (item.getId() == id) {
                item.reduce(n);
            }
        }
        this.updateInventory();
    }


    /**
     * Increases the quantity in stock of an item with id by n
     *
     * @param id: is the id of the item to be increased
     * @param n:  is the quantity increased of the item
     */
    public void add(int id, int n) {
        for (GroceryItem item : this.items) {
            if (item.getId() == id) {
                item.add(n);
            }
        }
        this.updateInventory();
    }


    /**
     * Puts the given items back into the inventory
     *
     * @param list is a list of grocery items
     */
    public void putBack(ArrayList<GroceryItem> list) {
        for (GroceryItem item : list) {
            int id = item.getId();
            int q = item.getQuantity();
            this.add(id, q);
        }
    }


    /**
     * Creates a new GroceryItem with a given id and quantity from the inventory
     *
     * @param id: is the id of the item
     * @param q:  is the quantity in stock of the item
     */
    public GroceryItem createItem(int id, int q) {
        for (GroceryItem i : this.items) {
            if (i.getId() == id) {
                String name = i.getName();
                double price = i.getPrice();
                return new GroceryItem(id, name, price, q);
            }
        }
        return null;
    }


    /**
     * Returns the quantity in stock of a given item
     *
     * @param id: is the id of the item
     */
    public int getQuantity(int id) {
        for (GroceryItem i : this.items) {
            if (i.getId() == id) {
                return i.getQuantity();
            }
        }
        return 0;
    }
}
