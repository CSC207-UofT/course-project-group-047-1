package interface_adapter;

import use_case.Order;
import use_case.OrderDataAccess;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * This class provides a string presentation of order infos
 */
public class OrderPresenter implements Iterable<Order> {

    public ArrayList<Order> orders;
    OrderDataAccess db;


    /**
     * Constructor
     */
    public OrderPresenter(OrderDataAccess db) {
        this.db = db;
        this.orders = db.read();
    }


    /**
     * Returns a string representation of the order history of a given account
     *
     * @param name: is the username of the account
     */
    public String view(String name) {
        this.orders = db.read();
        Iterator<Order> itr = orders.iterator();

        StringBuilder str = new StringBuilder();

        while (itr.hasNext()) {
            Order o = itr.next();
            if (o.getCustomer().equals(name)) {
                str.append(o.returnInfo());
            }
        }

        return str.toString();
    }


    /**
     * Returns an iterator that iterates through all orders
     */
    @Override
    public Iterator<Order> iterator() {
        return new OrderIterator();
    }

    /**
     * The iterator class for Order
     */
    private class OrderIterator implements Iterator<Order> {

        private int order = 0;


        /**
         * Check if the iterator has a next element
         *
         * @return true if the iterator has a next element, false if otherwise
         */
        @Override
        public boolean hasNext() {
            return this.order < db.read().size();
        }


        /**
         * Returns the next order in the list
         */
        @Override
        public Order next() {
            int curr_order = this.order;
            this.order += 1;
            return db.read().get(curr_order);
        }
    }

}
