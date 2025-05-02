import java.io.*;
import java.nio.file.*;

class CSVCountRows {
    // Problem 3: Read and Count Rows
    public static int countRows(String filePath) throws IOException {
        return (int) Files.lines(Paths.get(filePath)).skip(1).count();
    }

    public static void main(String[] args) throws IOException {
        String filePath = "employees.csv";
        System.out.println("Row Count: " + countRows(filePath));
    }
}
