/**
Khloe is working on this!
**/

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private Map<Integer, String> accounts;

    public AccountManager() {
        accounts = new HashMap<>();
    }

    public void storeUserName(String user, int number) {
        accounts.put(number, user);
    }

    public String getUserName(int number) {
        return accounts.get(number);   // this doesn't look right
    }
}
