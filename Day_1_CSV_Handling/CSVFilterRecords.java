import java.io.*;

class CSVFilterRecords {
    // Problem 4: Filter Records (Marks > 80)
    public static void filterCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Header
            System.out.println(line);
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (Integer.parseInt(values[3]) > 80) { // Assuming marks are in the 4th column
                    System.out.println(line);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = "students.csv"; // Ensure your CSV has ID, Name, Age, Marks
        System.out.println("Filtering Records with Marks > 80:");
        filterCSV(filePath);
    }
}
