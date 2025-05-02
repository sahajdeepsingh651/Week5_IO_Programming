import java.io.*;

class CSVSearchEmployee {
    // Problem 5: Search for an Employee by Name
    public static void searchEmployee(String filePath, String name) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[1].equalsIgnoreCase(name)) {
                    System.out.println("Department: " + values[2] + ", Salary: " + values[3]);
                    return;
                }
            }
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = "employees.csv";
        System.out.println("Searching for Employee: Jane Smith");
        searchEmployee(filePath, "Jane Smith");
    }
}
