package external_interface_test;

import external_interface.CustomerAccountAccess;
import org.junit.Test;
import use_case.CustomerAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerAccountAccessTest {

    private final String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
            "main" + File.separator + "database/file" + File.separator + "CustomerAccounts.txt";
    CustomerAccountAccess customerAccountAccess = new CustomerAccountAccess();


    /**
     * Test the accuracy of file writing and reading
     */
    @Test(timeout = 50)
    public void testRead() {

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path, true))) {
            fileWriter.write("name");
            fileWriter.newLine();
            fileWriter.write("2222");
            fileWriter.newLine();
            fileWriter.write("1000.0");
            fileWriter.newLine();
            fileWriter.write("0.0");
            fileWriter.newLine();
            fileWriter.write("all_black");
            fileWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean readAccurate = false;
        ArrayList<CustomerAccount> accounts = customerAccountAccess.read();
        for (CustomerAccount a: accounts) {
            if (Objects.equals(a.getUsername(), "name")) {
                readAccurate = true;
                break;
            }
        }
        assertTrue(readAccurate);
    }

    @Test(timeout = 50)
    public void testWrite() {
        ArrayList<CustomerAccount> accounts = customerAccountAccess.read();
        int n = accounts.size();
        accounts.add(new CustomerAccount("m", 111, 10.0, 10.0, "default"));
        customerAccountAccess.update(accounts);
        int m = customerAccountAccess.read().size();
        assertEquals(n + 1, m);
    }


}



