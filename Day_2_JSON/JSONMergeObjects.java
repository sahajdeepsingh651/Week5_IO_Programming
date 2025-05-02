import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;

class JSONMergeObjects {
    public static void mergeJSONFiles(String file1, String file2, String outputFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json1 = mapper.readTree(new File(file1));
        JsonNode json2 = mapper.readTree(new File(file2));

        ObjectNode merged = (ObjectNode) json1.deepCopy();
        json2.fields().forEachRemaining(field -> merged.set(field.getKey(), field.getValue()));

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), merged);
        System.out.println("Merged JSON saved to " + outputFile);
    }

    public static void main(String[] args) throws IOException {
        String file1 = "json1.json";
        String file2 = "json2.json";
        String outputFile = "merged.json";
        mergeJSONFiles(file1, file2, outputFile);
    }
}
