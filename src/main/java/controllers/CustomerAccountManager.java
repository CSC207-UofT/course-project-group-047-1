package controllers;

import use_case.CustomerAccount;

import java.io.*;
import java.util.Hashtable;


/**
 * A file writing class that stores all accounts into CustomerAccount.txt
 */
public class CustomerAccountManager {

    private final String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
            "main" + File.separator + "java" + File.separator + "files" + File.separator + "CustomerAccounts.txt";
    private final Hashtable<String, String> accounts = new Hashtable<>();


    /**
     * Constructor
     * Reads CustomerAccount.txt and collects all accounts into a hashmap
     */
    public CustomerAccountManager() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                this.accounts.put(line, reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Adds an CustomerAccount
     *
     * @param customerAccount: is the CustomerAccount to be added
     */
    public void addAccount(CustomerAccount customerAccount) {
        String user = customerAccount.getUsername();
        String pin = Integer.toString(customerAccount.getPin());

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path, true))) {
            fileWriter.write(user);
            fileWriter.newLine();
            fileWriter.write(pin);
            fileWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //add a new CustomerAccount to the hashtable
        this.accounts.put(user, pin);
    }


    /**
     * Checks credentials
     *
     * @param username: is the username of the account
     * @param pin:      is the pin of the account
     * @return true if pin is correct, false if otherwise
     */
    public boolean contains(String username, int pin) {
        if (this.accounts.containsKey(username)) {
            return this.accounts.get(username).equals(Integer.toString(pin));
        } else {
            return false;
        }

    }

}
