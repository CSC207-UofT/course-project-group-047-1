package use_case;

import java.util.ArrayList;

public interface OrderDataAccess {

        ArrayList<Order> read();

        void update(ArrayList<Order> orders);
}
