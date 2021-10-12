import java.time;

public class DeliveryPeople implements User {
    private String name;
    private int number;
    private String email;
    private String deliveryArea;
    private LocalTime time;

    public DeliveryPeople (String name, int number, String email, String area) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.deliveryArea = area;
        this.time = LocalTime.now();
    }
}
