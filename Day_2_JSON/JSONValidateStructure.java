import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.io.*;

class JSONValidateStructure {
    public static void validateJSON(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File(filePath));
            if (rootNode.isArray()) {
                System.out.println("Valid JSON Structure.");
            } else {
                System.out.println("Invalid JSON Structure: Root is not an array.");
            }
        } catch (MismatchedInputException e) {
            System.out.println("Invalid JSON Structure: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "sample.json"; // Replace with your JSON file path
        System.out.println("Validating JSON Structure:");
        validateJSON(filePath);
    }
}
