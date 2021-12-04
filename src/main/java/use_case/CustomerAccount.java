package use_case;
import entity.Balance;
import entity.Credit;


/**
 * An account stores the username and pin of a customer's account
 */
public class CustomerAccount implements Account {


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
     * @param cred:     the credit points of the account
     * @param balance:  the balance of the account
     * @param color:    the color theme of the account
     */
    public CustomerAccount(String username, int pin, Credit cred, Balance balance, String color) {
        this.username = username;
        this.pin = pin;
        this.cred = cred;
        this.balance = balance;
        this.color = color;
    }

    /**
     * Constructor
     *
     * @param username: the username of the account
     * @param pin:      the password of the account
     * @param cred:     the credit points of the account
     * @param balance:  the balance of the account
     * @param color:    the color theme of the account
     */
    public CustomerAccount(String username, int pin, double cred, double balance, String color) {
        this.username = username;
        this.pin = pin;
        this.cred = new Credit(cred);
        this.balance = new Balance(balance);
        this.color = color;
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


    /**
     * Returns the credit of the account
     */
    public double getCred() {return this.cred.getCred();}


    /**
     * Returns the balance of the account
     */
    public double getBal() {return this.balance.getBal();}


    /**
     * Returns the color of the account
     */
    public String getColor() {return this.color;}




    /**
     * Resets the username of the account
     * @param new_name: the new name of the account.
     */
    public void resetUsername(String new_name) {this.username = new_name;}


    /**
     * Resets the pin of the account
     * @param new_pin: the new pin of the account.
     */
    public void resetPin(int new_pin) {this.pin = new_pin;}


    /**
     * Sets the color of the account
     * @param color: the color to be set as theme color for the account.
     */
    public void setColor(String color) {this.color = color;}



    /**
     * Add credit points to the account
     * @param x: the amount of credit points to be added to the account.
     */
    public void addCred(double x) {this.cred.addCredit(x);}


    /**
     * Add balance to the account
     * @param y: the amount of balance to be added to the account.
     */
    public void addBal(double y){this.balance.addBal(y);}


    /**
     * Reduce credit points of the account
     * @param x: the amount of credit points to be removed from the account.
     */
    public void reduceCred(double x) {this.cred.removeCredit(x);}


    /**
     * Add balance of the account
     * @param y: the amount of balance to be removed from the account.
     */
    public void reduceBal(double y){this.balance.removeBal(y);}
}
