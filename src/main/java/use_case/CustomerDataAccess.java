package use_case;

import java.util.ArrayList;

public interface CustomerDataAccess {


    ArrayList<CustomerAccount> read();


    void update(ArrayList<CustomerAccount> accounts);
}
