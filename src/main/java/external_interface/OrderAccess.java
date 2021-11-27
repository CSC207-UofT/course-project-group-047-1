package external_interface;

import use_case.Order;
import use_case.OrderDataAccess;

import java.io.*;
import java.util.ArrayList;


public class OrderAccess implements OrderDataAccess {


    private final String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
            "main" + File.separator + "java" + File.separator + "files" + File.separator + "Orders.txt";


    @Override
    public ArrayList<Order> read() {

        ArrayList<Order> orders = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int quantity = Integer.parseInt(reader.readLine());
                double price = Double.parseDouble(reader.readLine());
                String status = reader.readLine();
                Order order = new Order(line, quantity, price, status);
                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orders;
    }


    @Override
    public void update(ArrayList<Order> orders) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            writer.print("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Order ord : orders) {
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
