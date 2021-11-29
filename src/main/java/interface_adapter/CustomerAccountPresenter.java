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
        Iterator<CustomerAccount> itr = accounts.iterator();

        StringBuilder str = new StringBuilder();

        while (itr.hasNext()){
            CustomerAccount a = itr.next();
            if (a.getUsername().equals(name)) {
                str.append("Username: ").append(a.getUsername()).append("\n");
            }
        }

        return str.toString();
    }


    public String viewPin(String name) {
        this.update();
        Iterator<CustomerAccount> itr = accounts.iterator();

        StringBuilder str = new StringBuilder();

        while (itr.hasNext()){
            CustomerAccount a = itr.next();
            if (a.getUsername().equals(name)) {
                str.append("Pin: ").append(a.getPin()).append("\n");
            }
        }

        return str.toString();
    }


    public String viewBal(String name) {
        this.update();
        Iterator<CustomerAccount> itr = accounts.iterator();

        StringBuilder str = new StringBuilder();

        while (itr.hasNext()){
            CustomerAccount a = itr.next();
            if (a.getUsername().equals(name)) {
                str.append("Balance: ").append(a.getBal()).append("\n");
            }
        }

        return str.toString();
    }


    public String viewCred(String name) {
        this.update();
        Iterator<CustomerAccount> itr = accounts.iterator();

        StringBuilder str = new StringBuilder();

        while (itr.hasNext()){
            CustomerAccount a = itr.next();
            if (a.getUsername().equals(name)) {
                str.append("Credit: ").append(a.getCred()).append("\n");
            }
        }

        return str.toString();
    }


    public String viewColor(String name) {
        this.update();
        Iterator<CustomerAccount> itr = accounts.iterator();

        StringBuilder str = new StringBuilder();

        while (itr.hasNext()){
            CustomerAccount a = itr.next();
            if (a.getUsername().equals(name)) {
                str.append("Color Preference: ").append(a.getColor()).append("\n");
            }
        }

        return str.toString();
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
