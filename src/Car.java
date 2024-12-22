import java.util.ArrayList;

public class Car {
    public String serialNumber;
    public String brand;
    public String model;
    public String color;
    public static ArrayList<Car> carList = new ArrayList<>();

    public Car(String serialNumber, String brand, String model, String color) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car {" +
                "serialNumber='" + serialNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
