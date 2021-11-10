package Entities;


//this class stores the information of a customer
public class Customer{


    private String name;


    //constructor
    public Customer (String name){this.name = name;}


    //a helper method
    public String getName(){return this.name;}


    //change name
    public void changeName(String name) {this.name = name;}
}