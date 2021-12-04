package external_interface;

import entity.GroceryItem;
import use_case.InventoryDataAccess;

import java.io.*;
import java.util.ArrayList;


/**
 * This class provide data access to Inventory.txt file
 */
public class InventoryAccess implements InventoryDataAccess {


    private final String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
            "main" + File.separator + "database/file" + File.separator + "Inventory.txt";


    /**
     * @return Read Inventory.txt file and return an ArrayList of GroceryItem
     */
    @Override
    public ArrayList<GroceryItem> read() {

        ArrayList<GroceryItem> items = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name = reader.readLine();
                double price = Double.parseDouble(reader.readLine());
                int quantity = Integer.parseInt(reader.readLine());
                GroceryItem g = new GroceryItem(Integer.parseInt(line), name, price, quantity);
                items.add(g);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;


    }


    /**
     * @param items
     * update Inventory.txt according to changes in items
     */
    @Override
    public void update(ArrayList<GroceryItem> items) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            writer.print("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (GroceryItem item : items) {
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
}
