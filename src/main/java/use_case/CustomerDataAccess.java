package use_case;

import java.util.ArrayList;


/**
 * Interface for data access to CustomerAccounts.txt file
 */
public interface CustomerDataAccess {


    /**
     * @return Read CustomerAccounts.txt file and return an ArrayList of CustomerAccount
     */
    ArrayList<CustomerAccount> read();


    /**
     * @param accounts
     * Update CustomerAccount.txt file according to changes in accounts
     */
    void update(ArrayList<CustomerAccount> accounts);
}
