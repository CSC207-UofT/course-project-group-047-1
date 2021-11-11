package Controllers;

import Use_Case.Order;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;


/**
 * this is a file writing class for Order's, they are stored in a file called Orders.txt
 */
public class OrderManager{

    private final String path = System.getProperty("user.dir") + File.separator + "Orders.txt";
    private final ArrayList<Order> orders = new ArrayList<>();


    /**
     * constructor
     * read Order.txt and collect all orders into an ArrayList
     */
    public OrderManager(){
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
     * add an order to Order.txt
     * @param name: String
     * @param quantity: int
     * @param price: double
     * @param status: String
     */
    public void addOrder(String name, int quantity, double price, String status) {

        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path, true))) {
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
        Order o = new Order(name, quantity, price, status);
        this.orders.add(o);
    }


    /**
     * check if a customer has an open order
     * @param name: name of customer
     * @return: return true if the customer has an open order, false if otherwise
     */
    public boolean haveOrder(String name) {
        for (Order o: this.orders) {
            if (Objects.equals(o.getCustomer(), name)) {
                if (Objects.equals(o.getStatus(), "open")) {return true;}
            }
        }
        return false;
    }


    /**
     * close all orders associate to this customer
     * @param name: customer's name
     */
    public void closeAll(String name){
        for (Order o: this.orders){
            if (Objects.equals(o.getCustomer(), name)){o.setStatus("closed");}
        }
        this.update();
    }


    /**
     * clear the entire file
     */
    public void clear() throws IOException{
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        writer.print("");
        writer.close();
    }


    /**
     * update the file according to the ArrayList
     */
    public void update(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            this.clear();
            for (Order ord: this.orders){
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
