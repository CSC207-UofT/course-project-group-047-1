package external_interface_test;

import external_interface.OrderAccess;
import org.junit.Test;
import use_case.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderAccessTest {

    private final String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +
            "main" + File.separator + "database/file" + File.separator + "Orders.txt";
    OrderAccess orderAccess = new OrderAccess();


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
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean readAccurate = false;
        ArrayList<Order> orders = orderAccess.read();
        for (Order o: orders) {
            if (Objects.equals(o.getCustomer(), "name")) {
                readAccurate = true;
                break;
            }
        }
        assertTrue(readAccurate);
    }


    @Test(timeout = 50)
    public void testWrite() {
        ArrayList<Order> orders = orderAccess.read();
        int n = orders.size();
        orders.add(new Order("m", 111, 10.0));
        orderAccess.update(orders);
        int m = orderAccess.read().size();
        assertEquals(n + 1, m);
    }

}
