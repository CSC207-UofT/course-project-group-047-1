package interface_adapter;

import use_case.Order;
import use_case.OrderDataAccess;

import java.util.ArrayList;
import java.util.Objects;


/**
 * This class manage all orders in the store
 */
public class OrderController {

    private final OrderDataAccess db;
    private final ArrayList<Order> orders;


    /**
     * Constructor
     */
    public OrderController(OrderDataAccess db) {
        this.db = db;
        this.orders = db.read();
    }


    /**
     * Adds an order to the system
     *
     * @param ord: is the order to be added
     */
    public void addOrder(Order ord) {
        this.orders.add(ord);
        this.db.update(this.orders);
    }


    /**
     * Checks if the customer has an open order
     *
     * @param name: name of customer
     * @return true if the customer has an open order, false if otherwise
     */
    public boolean haveOpenOrder(String name) {
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
        this.db.update(this.orders);
    }


    public void changeName(String name, String newName){
        for (Order o : this.orders){
            if (o.getCustomer().equals(name)){
                o.resetUsername(newName);
            }
        }
        this.db.update(this.orders);
    }


    public boolean haveOrder(String name) {
        for (Order o: this.orders) {
            if (Objects.equals(o.getCustomer(), name)) {return true;}
        }
        return false;
    }


}
