package Use_Case;

//An Order records a purchase buy a customer and the GroceryItems they bought

import Entities.Customer;
import Entities.GroceryItem;

import java.util.ArrayList;


public class Order{

    private final Customer customer;
    private final ArrayList<GroceryItem> items;


    //Constructor
    public Order(Customer customer, ArrayList<GroceryItem> items){
        this.customer = customer;
        this.items = items;
    }


    //Get methods
    public Customer getCustomer(){return this.customer;}


    public ArrayList<GroceryItem> getItems(){return this.items;}


    public int getTotalQuantity(){return this.items.size();}


    //Return total Price of the items
    public double getTotalPrice(){
        double total = 0;

        for (GroceryItem i : this.items){
            total += i.getPrice();
        }

        return total;
    }

    public String getCustomerName(){return this.customer.getName();}

}
