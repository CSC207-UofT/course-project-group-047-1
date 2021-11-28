package interface_adapter;

import use_case.CustomerAccount;
import use_case.CustomerDataAccess;

import java.util.ArrayList;

public class CustomerAccountPresenter {

    CustomerDataAccess db;

    ArrayList<CustomerAccount> accounts;

    public CustomerAccountPresenter(CustomerDataAccess db) {
        this.db = db;
        this.accounts = db.read();
    }

    public String view(String name) {

        for (CustomerAccount a : this.accounts) {
            if (a.getUsername().equals(name)) {
                return "Username: " + a.getUsername() + "\nPin: " + a.getPin() + "\nBalance: " + a.getBal()
                        + "\nCredit: " + a.getCred() + "\nColor Preference: " + a.getColor() + "\n";
            }
        }

        return "Account Not Found";
    }

}
