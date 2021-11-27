package interface_adapter;

import use_case.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;


/**
 * This is a file writing class that stores orders into Order.txt
 */
public class OrderController {

    private final String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
            "main" + File.separator + "java" + File.separator + "files" + File.separator + "Orders.txt";
    private final ArrayList<Order> orders = new ArrayList<>();


    /**
     * Constructor
     * Reads Order.txt and collects all orders into an ArrayList
     */
    public OrderController() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int quantity = Integer.parseInt(reader.readLine());
                double price = Double.parseDouble(reader.readLine());
                String status = reader.readLine();
                Order order = new Order(line, quantity, price, status);
                this.orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Adds an order to the system
     *
     * @param ord: is the order to be added
     */
    public void addOrder(Order ord) {

        String name = ord.getCustomer();
        int quantity = ord.getTotalQuantity();
        double price = ord.getValue();
        String status = ord.getStatus();

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path, true))) {
            fileWriter.write(name);
            fileWriter.newLine();
            fileWriter.write(Integer.toString(quantity));
            fileWriter.newLine();
            fileWriter.write(String.valueOf(price));
            fileWriter.newLine();
            fileWriter.write(status);
            fileWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.orders.add(ord);
    }


    /**
     * Checks if the customer has an open order
     *
     * @param name: name of customer
     * @return true if the customer has an open order, false if otherwise
     */
    public boolean haveOrder(String name) {
        for (Order o : this.orders) {
            if (Objects.equals(o.getCustomer(), name)) {
                if (Objects.equals(o.getStatus(), "open")) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Closes all orders associate to this customer
     *
     * @param name: is the customer's name
     */
    public void closeAll(String name) {
        for (Order o : this.orders) {
            if (Objects.equals(o.getCustomer(), name)) {
                o.setStatus("closed");
            }
        }
        this.update();
    }


    /**
     * Clears the entire file
     */
    public void clear() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        writer.print("");
        writer.close();
    }


    /**
     * Updates the file according to the ArrayList
     */
    public void update() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            this.clear();
            for (Order ord : this.orders) {
                String name = ord.getCustomer();
                writer.write(name);
                writer.newLine();
                writer.write(Integer.toString(ord.getTotalQuantity()));
                writer.newLine();
                writer.write(String.valueOf(ord.getValue()));
                writer.newLine();
                writer.write(ord.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
