package Use_Case;

import Entities.Customer;
import Entities.GroceryItem;

import java.util.ArrayList;


public class Order{

    private final Customer customer;
    private final ArrayList<GroceryItem> items;


    public Order(Customer customer, ArrayList<GroceryItem> items){
        this.customer = customer;
        this.items = items;
    }

    public Customer getCustomer(){return this.customer;}

    public ArrayList<GroceryItem> getItems(){return this.items;}

    public int getTotalQuantity(){return this.items.size();}

    public double getTotalPrice(){
        double total = 0;

        for (GroceryItem i : this.items){
            total += i.getPrice();
        }

        return total;
    }

    public String getCustomerName(){return this.customer.getName();}

}
