package entity_test;

import entity.Balance;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BalanceTest {
    Balance bal1;
    Balance bal2;

    @Before
    public void setUp() {
        bal1 = new Balance();
        bal2 = new Balance(2);
    }

    @Test(timeout = 50)
    public void testGetBal() {
        assertEquals(0.0, bal1.getBal(), 0.0);
        assertEquals(2.0, bal2.getBal(), 0.0);
    }

    @Test(timeout = 50)
    public void testAddBal() {
        bal1.addBal(1);
        bal2.addBal(1);
        assertEquals(1.0, bal1.getBal(), 0.0);
        assertEquals(3.0, bal2.getBal(), 0.0);
    }
}
