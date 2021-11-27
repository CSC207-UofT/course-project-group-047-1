package use_case;


/**
 * An account stores the username and pin of a customer's account
 */
public class CustomerAccount extends UserAccount {


    private final String username;
    private final int pin;


    /**
     * Constructor
     *
     * @param username: the username of the account
     * @param pin:      the password of the account
     */
    public CustomerAccount(String username, int pin) {
        this.username = username;
        this.pin = pin;
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
