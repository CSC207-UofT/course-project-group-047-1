package entities;

public class Credit {

    private double cred;

    public Credit() {
        this.cred = 0;
    }

    public void addCredit(double c) {
        this.cred += c;
    }

    public void removeCredit(double c) {
        this.cred -= c;
    }

}