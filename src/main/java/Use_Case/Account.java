package Use_Case;


import Entities.Customer;

//this class stores information of a customer's account
public class Account {


    String username;
    int pin;


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


