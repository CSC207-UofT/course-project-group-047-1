package interface_adapter;

import use_case.CustomerAccount;
import use_case.CustomerDataAccess;

import java.util.ArrayList;

public class CustomerAccountPresenter {

    CustomerDataAccess db;
    ArrayList<CustomerAccount> accounts;
    CustomerAccount account;

    public CustomerAccountPresenter(CustomerDataAccess db, String username) {
        this.db = db;
        this.accounts = db.read();
        for (CustomerAccount a : this.accounts) {
            if (a.getUsername().equals(username)) {
                this.account = a;
            }
        }
    }


    private void update() {
        this.accounts = db.read();
    }


    public String viewName() {
        this.update();
        return "Username: " + this.account.getUsername() + "\n";
    }


    public String viewPin() {
        this.update();
        return "Pin: " + this.account.getPin() + "\n";
    }


    public String viewBal() {
        this.update();
        return "Balance: " + this.account.getBal() + "\n";
    }


    public String viewCred() {
        this.update();
        return "Credit: " + this.account.getCred() + "\n";
    }


    public String viewColor() {
        this.update();
        return "Color Preference: " + this.account.getColor() + "\n";
    }

}
