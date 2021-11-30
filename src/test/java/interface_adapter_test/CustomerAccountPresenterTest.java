package interface_adapter_test;

import external_interface.CustomerAccountAccess;
import interface_adapter.CustomerAccountPresenter;
import org.junit.Before;
import org.junit.Test;
import use_case.CustomerDataAccess;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerAccountPresenterTest {

    CustomerAccountPresenter CAPre;
    CustomerDataAccess db = new CustomerAccountAccess();

    @Before
    public void setUp() {
        CAPre = new CustomerAccountPresenter(db);

    }

    @Test
    public void testViewName() {
        assertEquals("eddy", CAPre.viewName("eddy"));
    }

    @Test
    public void testViewPin() {
        assertEquals(1111, CAPre.viewPin("eddy"));
    }

}