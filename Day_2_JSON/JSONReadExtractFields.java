import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

class JSONReadExtractFields {
    public static void readAndExtractFields(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File(filePath));

        for (JsonNode node : rootNode) {
            System.out.println("Name: " + node.get("name").asText());
            System.out.println("Email: " + node.get("email").asText());
            System.out.println("---");
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = "users.json"; // Ensure JSON has an array of user objects with "name" and "email" fields
        System.out.println("Extracting Specific Fields from JSON:");
        readAndExtractFields(filePath);
    }
}
