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

    public String viewName() {return "Username: " + this.account.getUsername() + "\n";}


    public String viewPin() {return "Pin: " + this.account.getPin() + "\n";}


    public String viewBal() {return "Balance: " + this.account.getBal() + "\n";}


    public String viewCred() {return "Credit: " + this.account.getCred() + "\n";}


    public String viewColor() {return "Color Preference: " + this.account.getColor() + "\n";}

}
