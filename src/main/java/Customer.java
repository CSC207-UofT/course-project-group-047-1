public class Customer {
    private String username;
    private int pin;
    private String email;
    private String address;
    private ShoppingCart cart;

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


    public int getpin() {return this.pin;}


}
