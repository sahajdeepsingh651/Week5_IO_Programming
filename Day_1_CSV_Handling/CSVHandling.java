import java.io.*;

class CSVReadAndPrint {
    // Problem 1: Read and Print CSV Data
    public static void readCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = "employees.csv";
        System.out.println("Reading CSV:");
        readCSV(filePath);
    }
}
