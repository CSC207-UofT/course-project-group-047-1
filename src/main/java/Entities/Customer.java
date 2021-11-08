package Entities;

//this class stores the information of a customer

public class Customer{


    private String name;


    //Constructor
    public Customer (String name){this.name = name;}


    //A helper method
    public String getName(){return this.name;}


    //Change name
    public void ChangeName(String name) {this.name = name;}
}