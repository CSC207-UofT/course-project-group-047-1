public class Customer implements User {
    private String username;
    private int pin;
    private String email;
    private String address;

    public Customer (String username, int pin, String email, String address) {
        this.username = name;
        this.pin = pin;
        this.email = email;
        this.address = address;
    }

    public Customer (String username, int pin, String address) {
        this.username = username;
        this.pin = pin;
        this.address = address;
        this.email = "";
    }
}
