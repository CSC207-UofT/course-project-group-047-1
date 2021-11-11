package Controllers;

import Entities.GroceryItem;
import java.io.*;
import java.util.ArrayList;


/**
 * this is a file writing class that store GroceryItem into Inventory.txt
 */
public class GroceryInventory {

    private final String path = System.getProperty("user.dir") + File.separator + "Inventory.txt";
    private final ArrayList<GroceryItem> items = new ArrayList<>();


    /**
     * constructor, read the file and collect all items into an ArrayList
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
     * push changes in the ArrayList into Inventory.txt
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
     * @return: return a string representation of GroceryItems in the store
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
     * clear the file
     */
    public void clear() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        writer.print("");
        writer.close();
    }


    /**
     * reduce the quantity of an item with id by n
     *
     * @param id: int
     * @param n:  int
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
     *  increases the quantity of item with id by n
     *
     * @param id:  int
     * @param n:   int
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
     * puts the given items back into the inventory
     *
     * @param list: ArrayList<GroceryItem>
     */
    public void putBack(ArrayList<GroceryItem> list) {
        for (GroceryItem item : list) {
            int id = item.getId();
            int q = item.getQuantity();
            this.add(id, q);
        }
    }


    /**
     * creates a new GroceryItem with a given id and quantity from the inventory
     *
     * @param id:  int
     * @param q:   int
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
     * returns the quantity of a given object
     *
     * @param id:  int
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
