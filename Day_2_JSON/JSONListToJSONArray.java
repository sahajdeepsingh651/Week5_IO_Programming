import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

class Person {
    private String name;
    private int age;

    // Constructors, Getters, and Setters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

class JSONListToJSONArray {
    public static void listToJSON(String filePath) throws IOException {
        List<Person> people = Arrays.asList(
                new Person("Alice", 28),
                new Person("Bob", 32),
                new Person("Charlie", 24)
        );

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), people);

        System.out.println("List converted to JSON Array successfully.");
    }

    public static void main(String[] args) throws IOException {
        String filePath = "people.json";
        listToJSON(filePath);
    }
}
