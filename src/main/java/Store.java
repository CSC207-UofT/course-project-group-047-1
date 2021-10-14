import java.io.IOException;

/** this is the command line interface that should be run when someone wants to launch the program.
 *
 */

public class Store {


    public static void main(String[] args) throws IOException {
        GroceryInventory G = new GroceryInventory();
        G.view();

        Menu m = new Menu();
        m.create_account_menu();
    }
}
