package entity;

public class Credit {

    private double cred;

    /**
     * Constructor
     * Initiates Credit with a value of 0
     */
    public Credit() {
        this.cred = 0;
    }

    /**
     * Overload for constructor
     * @param cred: The amount to initiate Credit with
     */
    public Credit(double cred){
        this.cred = cred;
    }

    /**
     * Adds a given number of credits
     * @param c: amount to be added
     */
    public void addCredit(double c) {
        this.cred += c;
    }

    /**
     * Removes a given number of credits
     * @param c: amount to be removed
     */
    public void removeCredit(double c) {
        this.cred -= c;
    }

    /**
     * Sets the number of credits to the given amount
     * @param c: amount to be set to
     */
    public void setCred(double c) {
        this.cred = c;
    }

    /**
     * Returns the number of credits
     * @return: number of credits
     */
    public double getCred() {return this.cred;}

}