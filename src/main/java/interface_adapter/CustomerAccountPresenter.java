package interface_adapter;

import use_case.CustomerAccount;
import use_case.CustomerDataAccess;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomerAccountPresenter implements Iterable<CustomerAccount>{

    CustomerDataAccess db;
    ArrayList<CustomerAccount> accounts;

    public CustomerAccountPresenter(CustomerDataAccess db) {
        this.db = db;
        this.accounts = db.read();
    }


    private void update() {
        this.accounts = db.read();
    }


    public String viewName(String name) {
        this.update();

        for (CustomerAccount a : accounts) {
            if (a.getUsername().equals(name)) {
                return (a.getUsername());
            }
        }
        return "";
    }


    public int viewPin(String name) {
        this.update();

        for (CustomerAccount a : accounts) {
            if (a.getUsername().equals(name)) {
                return a.getPin();
            }
        }
        return 0;
    }


    public double viewBal(String name) {
        this.update();

        for (CustomerAccount a : accounts) {
            if (a.getUsername().equals(name)) {
                return a.getBal();
            }
        }
        return 0;
    }


    public double viewCred(String name) {
        this.update();

        for (CustomerAccount a : accounts) {
            if (a.getUsername().equals(name)) {
                return a.getCred();
            }
        }
        return 0;
    }


    public String viewColor(String name) {
        this.update();

        for (CustomerAccount a : accounts) {
            if (a.getUsername().equals(name)) {
                return a.getColor();
            }
        }
        return "";
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
