import java.io.*;
import java.util.*;

public class CSVWrite {
    // Problem 2: Write Data to CSV File
    public static void writeCSV(String filePath) throws IOException {
        List<String[]> data = Arrays.asList(
                new String[]{"ID", "Name", "Department", "Salary"},
                new String[]{"1", "John Doe", "IT", "50000"},
                new String[]{"2", "Jane Smith", "HR", "45000"},
                new String[]{"3", "Alice Brown", "IT", "55000"},
                new String[]{"4", "Bob White", "Finance", "60000"},
                new String[]{"5", "Charlie Black", "Marketing", "40000"}
        );
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        }
        System.out.println("CSV file written successfully.");
    }

    public static void main(String[] args) throws IOException {
        String filePath = "employees.csv";
        writeCSV(filePath);
    }
}
