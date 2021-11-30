package interface_adapter_test;

import external_interface.InventoryAccess;
import interface_adapter.InventoryPresenter;
import org.junit.Before;
import org.junit.Test;
import use_case.InventoryDataAccess;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryPresenterTest {

    InventoryPresenter InPre;
    InventoryDataAccess db = new InventoryAccess();

    @Before
    public void setUp() {
        InPre = new InventoryPresenter(db);
    }

    @Test(timeout = 50)
    public void testView() {
        assertEquals("1 Apple x 100, Price: 4.0$ each\n" +
                "2 Orange x 100, Price: 3.0$ each\n" +
                "3 banana x 100, Price: 3.5$ each\n" +
                "4 pomegranate x 100, Price: 5.0$ each\n" +
                "5 mask x 100, Price: 1.0$ each\n", InPre.view());
    }
}