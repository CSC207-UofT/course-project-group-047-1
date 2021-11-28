package use_case;


/**
 * An interface for all accounts in the program, also for
 * future extension
 */
public interface Account {


    /**
     * @return returns the username of this account
     */
    String getUsername();


    /**
     * @return returns the pin of this account
     */
    int getPin();


}
