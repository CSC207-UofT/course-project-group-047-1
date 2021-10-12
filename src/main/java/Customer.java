public class Customer implements User {
    private String username;
    private int pin;
    private String email;
    private String paymentInfo;
    private String address

    public Customer (String username, int pin, String email, String paymentInfo, String address) {
        this.username = name;
        this.pin = pin;
        this.email = email;
        this.paymentInfo = paymentInfo;
        this.address = address;
    }

    public Customer (String username, int pin, String address) {
        this.username = username;
        this.pin = pin;
        this.address = address;
        this.email = "";
        this.paymentInfo = "";
    }
}
