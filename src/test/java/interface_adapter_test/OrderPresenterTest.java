package interface_adapter_test;

import interface_adapter.OrderPresenter;
import use_case.Order;
import use_case.OrderDataAccess;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderPresenterTest {

    OrderPresenter presenter;
    OrderDataAccess db;
    public ArrayList<Order> orders;
    Order order;

    @Before
    public void setUp() {
        order = new Order("Adam", 5, 20.0, "open");
        db = new OrderDataAccess() {
            @Override
            public ArrayList<Order> read() {
                return null;
            }

            @Override
            public void update(ArrayList<Order> orders) {

            }
        };
        presenter = new OrderPresenter(db);
    }
    /**
     * don't know how to fix the above?
     */

    @Test(timeout = 50)
    public void testView() {
        String expected = "Status: open\nTotal number of items: 5\nTotal price: 20.0\n\n";
        assertEquals(expected, presenter.view("Adam"));
    }

    /**
     * how to test the rest of the methods?
     */

}
