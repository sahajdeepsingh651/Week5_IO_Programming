import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

class Car {
    private String make;
    private String model;
    private int year;

    // Constructors, Getters, and Setters
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}

class JSONJavaObjectToJSON {
    public static void convertCarToJSON(String filePath) throws IOException {
        Car car = new Car("Toyota", "Camry", 2022);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), car);

        System.out.println("Car JSON created successfully.");
    }

    public static void main(String[] args) throws IOException {
        String filePath = "car.json";
        convertCarToJSON(filePath);
    }
}
