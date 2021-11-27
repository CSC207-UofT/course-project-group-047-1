package use_case;
import entities.Balance;
import entities.Credit;


/**
 * An account stores the username and pin of a customer's account
 */
public class CustomerAccount extends UserAccount {


    private final String username;
    private final int pin;
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


}
