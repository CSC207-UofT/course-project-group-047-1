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

    @Test(timeout = 50)
    public void testViewName() {
        assertEquals("example", CAPre.viewName("example"));
    }

    @Test(timeout = 50)
    public void testViewPin() {
        assertEquals(1111, CAPre.viewPin("example"));
    }

    @Test(timeout = 50)
    public void testViewBal() {
        assertEquals(0.0, CAPre.viewBal("example"));
    }

    @Test(timeout = 50)
    public void testViewCred() {
        assertEquals(1.0, CAPre.viewCred("example"));
    }

    @Test(timeout = 50)
    public void testViewColor() {
        assertEquals("invert", CAPre.viewColor("example"));
    }
}