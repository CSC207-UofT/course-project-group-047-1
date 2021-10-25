public class Customer {


    private final String username;
    private final int pin;
    private final String email;
    private final String address;
    private final ShoppingCart cart;


    public Customer (String username, int pin, String email, String address) {

        this.username = username;
        this.pin = pin;
        this.email = email;
        this.address = address;
        this.cart = new ShoppingCart();

    }


    public Customer (String username, int pin) {

        this.username = username;
        this.pin = pin;
        this.address = "";
        this.email = "";
        this.cart = new ShoppingCart();

    }


    public String getUsername() {return this.username;}


    public int getPin() {return this.pin;}


}
