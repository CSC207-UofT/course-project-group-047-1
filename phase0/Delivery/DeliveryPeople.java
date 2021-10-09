import java.time.LocalTime;

public class DeliveryPeople implements User {
    private String name;
    private int number;
    private String email;
    private String delivery_area;
    private LocalTime time;

    public DeliveryPeople (String name, int number, String email, String area) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.delivery_area = area;
        this.time = LocalTime.now();
    }
}
