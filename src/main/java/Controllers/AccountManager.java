package Controllers;

import Use_Case.Account;
import java.io.*;
import java.util.Hashtable;


/**
 * a file  writing class that stores Accounts in a file called Accounts.txt
 */
public class AccountManager{

    private final String path = System.getProperty("user.dir") + File.separator + "Accounts.txt";
    private final Hashtable<String, String> accounts = new Hashtable<>();


    /**
     * constructor
     * read Account.txt and collect all accounts into a hashmap
     */
    public AccountManager() {
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
     * add a account
     * @param account: account to be added
     */
    public void addCustomer(Account account) {
        //add a new account to the hashtable
        String user = account.getUsername();
        String pin = Integer.toString(account.getPin());

        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path, true))) {
            fileWriter.write(user);
            fileWriter.newLine();
            fileWriter.write(pin);
            fileWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.accounts.put(user, pin);
    }


    /**
     * create and return an account
     * @param name: String
     * @param pin: int
     * @return: Account
     */
    public Account createAccount (String name, int pin) {
        return new Account(name, pin);
    }

    /**
     * check credentials
     * @param username: String
     * @param pin: int
     * @return: true if pin is right, false if otherwise
     */
    public boolean contains(String username, int pin) {
        if (this.accounts.containsKey(username)) {
            return this.accounts.get(username).equals(Integer.toString(pin));
        } else {
            return false;
        }

    }

}
