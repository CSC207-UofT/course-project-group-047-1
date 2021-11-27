package use_case;
import entities.Balance;
import entities.Credit;


/**
 * An account stores the username and pin of a customer's account
 */
public class CustomerAccount extends UserAccount {


    private String username;
    private int pin;
    Credit cred;
    Balance balance;
    String color;


    /**
     * Constructor
     *
     * @param username: the username of the account
     * @param pin:      the password of the account
     */
    public CustomerAccount(String username, int pin, Credit cred, Balance balance, String color) {
        this.username = username;
        this.pin = pin;
        this.cred = cred;
        this.balance = balance;
        this.color = "default";
    }


    /**
     * Returns the username of the account
     */
    @Override
    public String getUsername() {return this.username;}


    /**
     * Returns the pin of the account
     */
    @Override
    public int getPin() {return this.pin;}


    public Credit getCred() {return this.cred;}


    public Balance getBal() {return this.balance;}


    public String getColor() {return this.color;}




    public void resetUsername(String new_name) {this.username = new_name;}


    public void resetPin(int new_pin) {this.pin = new_pin;}


    public void setColor(String color) {this.color = color;}



    public void addCred(double x) {this.cred.addCredit(x);}


    public void addBal(double y){this.balance.addBal(y);}


    public void reduceCred(double x) {this.cred.removeCredit(x);}


    public void reduceBal(double y){this.balance.removeBal(y);}
}
