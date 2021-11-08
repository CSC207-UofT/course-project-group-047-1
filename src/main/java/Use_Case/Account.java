package Use_Case;


import Entities.Customer;


//An Account stores the information of a customer's account
public class Account {


    private final String username;
    private final int pin;


    //constructor
    public Account(String username, int pin){
        this.username = username;
        this.pin = pin;
    }


    //another constructor
    public Account(Customer customer, int pin){
        this.username = customer.getName();
        this.pin = pin;
    }


    //a get method
    public String getUsername(){return this.username;}

    //another get method
    public int getPin(){return this.pin;}


}


