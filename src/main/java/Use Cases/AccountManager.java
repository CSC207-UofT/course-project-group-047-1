import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class AccountManager{

    private String path = System.getProperty("user.dir") + File.separator + "Accounts.txt";
    private Hashtable<String, String> accounts = new Hashtable<String, String>();


    public AccountManager() {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                this.accounts.put(line, reader.readLine());
                reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void add_customer(Customer customer) {
        String user = customer.getUsername();
        String pin = Integer.toString(customer.getPin());

        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path))) {
            fileWriter.write(user + "\n" + pin + "\n" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.accounts.put(user, pin);
    }


    public boolean contains(String username) {

        return this.accounts.contains(username);

    }


}

