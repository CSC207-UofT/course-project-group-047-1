package use_case;


/**
 * An abstract class for extension
 */
public abstract class UserAccount implements Account{


    /**
     * @return default returns the username of this account
     */
    public String getUsername() {
        return "";
    }


    /**
     * @return default returns the pin of this account
     */
    public int getPin() {
        return 0;
    }


}
