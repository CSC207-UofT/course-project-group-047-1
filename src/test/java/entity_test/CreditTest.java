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
    public void testGetCred() {
        assertEquals(0.0, cred1.getCred(), 0.0);
        assertEquals(2.0, cred2.getCred(), 0.0);
    }

    @Test(timeout = 50)
    public void testAddCred() {
        cred1.addCredit(1);
        cred2.addCredit(1);
        assertEquals(1.0, cred1.getCred(), 0.0);
        assertEquals(3.0, cred2.getCred(), 0.0);
    }

    @Test(timeout = 50)
    public void testRemoveCred() {
        cred1.removeCredit(1);
        cred2.removeCredit(1);
        assertEquals(-1.0, cred1.getCred(), 0.0);
        assertEquals(1.0, cred2.getCred(), 0.0);
    }

    @Test(timeout = 50)
    public void testSetCred() {
        cred1.setCred(10);
        cred2.setCred(10);
        assertEquals(cred1.getCred(), cred2.getCred(), 0.0);
    }

}
