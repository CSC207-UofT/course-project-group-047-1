package Controllers;


//This is a file writing class for Order's, they are stored in a file called Orders.txt

import Use_Case.Order;

import java.io.*;
import java.util.ArrayList;

public class OrderManager{

    private final String path = System.getProperty("user.dir") + File.separator + "Orders.txt";
    private final ArrayList<Order> orders = new ArrayList<>();

    public OrderManager(){
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((reader.readLine()) != null) {
                String name = reader.readLine();
                int quantity = Integer.parseInt(reader.readLine());
                double price = Double.parseDouble(reader.readLine());
                Order order = new Order(name, quantity, price);
                this.orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addOrder(Order order) {
        String name = order.getCustomer();
        int quantity = order.getTotalQuantity();
        double price = order.getValue();

        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path, true))) {
            fileWriter.write(name);
            fileWriter.newLine();
            fileWriter.write(Integer.toString(quantity));
            fileWriter.newLine();
            fileWriter.write(String.valueOf(price));
            fileWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Order o = new Order(name, quantity, price);
        this.orders.add(o);
    }

}
