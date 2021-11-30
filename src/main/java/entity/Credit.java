package entity;

public class Credit {

    private double cred;

    public Credit() {
        this.cred = 0;
    }

    public Credit(double cred){
        this.cred = cred;
    }

    public void addCredit(double c) {
        this.cred += c;
    }

    public void removeCredit(double c) {
        this.cred -= c;
    }

    public void setCred(double c) {
        this.cred = c;
    }

    public double getCred() {return this.cred;}

}