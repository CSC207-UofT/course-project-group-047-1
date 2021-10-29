import java.io.*;
import java.util.Hashtable;

public class AccountManager{

    private final String path = System.getProperty("user.dir") + File.separator + "Accounts.txt";
    private final Hashtable<String, String> accounts = new Hashtable<String, String>();


    public AccountManager() {
        //if accounts exist in the file, add them to the hashtable.
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                this.accounts.put(line, reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void add_customer(Customer customer) {
        //add a new account to the hashtable
        String user = customer.getUsername();
        String pin = Integer.toString(customer.getPin());

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


    public boolean contains(String username, int pin) {
        if (this.accounts.containsKey(username)) {
            return this.accounts.get(username).equals(Integer.toString(pin));
        } else {
            return false;
        }

    }


}

