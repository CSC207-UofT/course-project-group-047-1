package interface_adapter_test;

import external_interface.OrderAccess;
import interface_adapter.OrderPresenter;
import org.junit.Before;
import org.junit.Test;
import use_case.OrderDataAccess;

import static org.junit.jupiter.api.Assertions.*;


public class OrderPresenterTest {
    OrderPresenter OrPre;
    OrderDataAccess db = new OrderAccess();

    @Before
    public void setUp() {
        OrPre = new OrderPresenter(db);
    }

    @Test (timeout = 50)
    public void testView() {
        assertEquals("Status: closed\n" +
                "Total number of items: 11\n" +
                "Total price: 10.0\n\n", OrPre.view("example"));
    }
}