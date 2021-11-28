package interface_adapter;

import use_case.Order;
import use_case.OrderDataAccess;

import java.util.ArrayList;
import java.util.Iterator;


public class OrderPresenter implements Iterable<Order>{

    OrderDataAccess db;

    public ArrayList<Order> orders;

    public OrderPresenter(OrderDataAccess db) {
        this.db = db;
        this.orders = db.read();
    }


    public String view(String name) {
        this.orders = db.read();

        StringBuilder str = new StringBuilder();

        for (Order o : this.orders){
            if (o.getCustomer().equals(name)){
                str.append(o.returnInfo());
            }
        }
        return str.toString();
    }


    @Override
    public Iterator<Order> iterator() {
        return new OrderIterator();
    }


    private class OrderIterator implements Iterator<Order>{

        private int order = 0;

        @Override
        public boolean hasNext() {
            return this.order < db.read().size();
        }


        @Override
        public Order next() {
            this.order += 1;
            return db.read().get(order);
        }
    }


}
