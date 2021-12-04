package use_case;

import java.util.ArrayList;


/**
 * Interface for data access of Orders.txt file
 */
public interface OrderDataAccess {

        /**
         * @return Read Orders.txt and return an ArrayList of Order
         */
        ArrayList<Order> read();

        /**
         * @param orders
         * update Orders.txt according to changes in orders
         */
        void update(ArrayList<Order> orders);
}
