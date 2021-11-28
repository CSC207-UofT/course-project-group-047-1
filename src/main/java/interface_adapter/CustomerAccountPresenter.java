package interface_adapter;

import use_case.CustomerAccount;
import use_case.CustomerDataAccess;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomerAccountPresenter implements Iterable<CustomerAccount>{

    CustomerDataAccess db;
    ArrayList<CustomerAccount> accounts;
    CustomerAccount account;

    public CustomerAccountPresenter(CustomerDataAccess db, String username) {
        this.db = db;
        this.accounts = db.read();

        Iterator<CustomerAccount> itr = this.accounts.iterator();

        this.account = null;

        while (itr.hasNext()){
            CustomerAccount a = itr.next();
            if (a.getUsername().equals(username)) {
                this.account = a;
                break;
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


    @Override
    public Iterator<CustomerAccount> iterator() {
        return new CustomerAccountIterator();
    }


    private class CustomerAccountIterator implements Iterator<CustomerAccount>{

        private int customer = 0;

        @Override
        public boolean hasNext() {
            return this.customer < db.read().size();
        }


        @Override
        public CustomerAccount next() {
            int curr_customer = this.customer;
            this.customer += 1;
            return db.read().get(curr_customer);
        }
    }
}
