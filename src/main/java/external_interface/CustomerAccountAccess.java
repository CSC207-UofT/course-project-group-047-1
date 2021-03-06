package external_interface;

import entity.Balance;
import entity.Credit;
import use_case.CustomerAccount;
import use_case.CustomerDataAccess;

import java.io.*;
import java.util.ArrayList;


/**
 * This class provide data access to CustomerAccounts.txt file
 */
public class CustomerAccountAccess implements CustomerDataAccess {


    private final String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
            "main" + File.separator + "database/file" + File.separator + "CustomerAccounts.txt";


    /**
     * @return Read CustomerAccounts.txt file and return an ArrayList of CustomerAccount
     */
    @Override
    public ArrayList<CustomerAccount> read() {

        ArrayList<CustomerAccount> accounts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name = line;
                line = reader.readLine();
                int pin = Integer.parseInt(line);
                line = reader.readLine();
                Credit credit = new Credit(Double.parseDouble(line));
                line = reader.readLine();
                Balance balance = new Balance(Double.parseDouble(line));
                line = reader.readLine();
                String color = line;
                CustomerAccount a = new CustomerAccount(name, pin, credit, balance, color);
                accounts.add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }


    /**
     * @param accounts
     * Update CustomerAccount.txt file according to changes in accounts
     */
    @Override
    public void update(ArrayList<CustomerAccount> accounts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            writer.print("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path, true))) {
            for(CustomerAccount a: accounts) {
                String name = a.getUsername();
                int pin = a.getPin();
                double credit = a.getCred();
                double balance = a.getBal();
                String color = a.getColor();
                fileWriter.write(name);
                fileWriter.newLine();
                fileWriter.write(String.valueOf(pin));
                fileWriter.newLine();
                fileWriter.write(String.valueOf(credit));
                fileWriter.newLine();
                fileWriter.write(String.valueOf(balance));
                fileWriter.newLine();
                fileWriter.write(color);
                fileWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
