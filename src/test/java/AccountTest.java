import use_case.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    Account account;

    @Before
    public void setUp() {account = new Account("username", 12345);}

    @Test(timeout = 50)
    public void testGetUsername() {assertEquals("username", account.getUsername());}

    @Test(timeout = 50)
    public void testGetPin() {assertEquals(12345, account.getPin());}

}

