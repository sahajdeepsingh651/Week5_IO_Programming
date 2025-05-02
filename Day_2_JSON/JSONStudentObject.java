import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

class JSONStudentObject {
    // Problem 1: Create JSON Object for Student
    public static void createStudentJSON(String filePath) throws IOException {
        Map<String, Object> student = new HashMap<>();
        student.put("name", "John Doe");
        student.put("age", 20);
        student.put("subjects", Arrays.asList("Math", "Science", "English"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), student);

        System.out.println("Student JSON created successfully.");
    }

    public static void main(String[] args) throws IOException {
        String filePath = "student.json";
        createStudentJSON(filePath);
    }
}
