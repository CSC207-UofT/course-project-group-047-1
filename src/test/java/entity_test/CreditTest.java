package entity_test;

import entity.Credit;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CreditTest {
    Credit cred1;
    Credit cred2;

    @Before
    public void setUp() {
        cred1 = new Credit();
        cred2 = new Credit(2);
    }

    @Test(timeout = 50)
    public void getCred() {
        assertEquals(0, cred1.getCred(), 0.0);
        assertEquals(2.0, cred2.getCred(), 0.0);
    }

}
