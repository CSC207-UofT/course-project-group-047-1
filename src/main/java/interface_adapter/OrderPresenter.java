package interface_adapter;

import use_case.Order;
import use_case.OrderDataAccess;

import java.util.ArrayList;

public class OrderPresenter {

    OrderDataAccess db;

    ArrayList<Order> orders;

    public OrderPresenter(OrderDataAccess db) {
        this.db = db;
        this.orders = db.read();
    }


    public String view(String name) {

        StringBuilder str = new StringBuilder();

        for (Order o : this.orders){
            if (o.getCustomer().equals(name)){
                str.append(o.returnInfo());
            }
        }
        return str.toString();
    }

}
