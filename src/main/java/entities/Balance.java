package entities;

public class Balance {

    private double bal;

    /**
     * Constructor
     * Initiates a balance with value 0
     */
    public Balance() {
        this.bal = 0;
    }

    /**
     * Overload for constructor
     * @param b: the starting balance
     */
    public Balance(double b) {
        this.bal = b;
    }

    /**
     * Adds an amount to the balance
     * @param b: the amount to be added
     */
    public void addBal(double b) {
        this.bal += b;
    }

    /**
     * Removes a given amount from the balance
     * @param b: the amount to be removed
     * @return: returns true if the amount is successfully removed (balance isn't negative)
     */
    public void removeBal(double b) {
        this.bal -= b;
    }

    /**
     * returns the balance
     * @return: the current balance
     */
    public double getBal() {
        return this.bal;
    }
}
