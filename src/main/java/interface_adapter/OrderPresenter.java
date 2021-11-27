package interface_adapter;

import use_case.Order;
import use_case.OrderDataAccess;

import java.util.ArrayList;

public class OrderPresenter {

    OrderDataAccess db;

    ArrayList<Order> orders;

    public OrderPresenter(OrderDataAccess db) {
        this.db = db;
        this.orders = this.db.read();
    }

    //TODO this method returns a string representation of all orders
    public String view() {
        return "";
    }

    //TODO this method returns a string representation of order by a specific customer
    public String view(String name) {
        return "";
    }

}
