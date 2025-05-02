import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    String username;

    @JsonField(name = "user_email")
    String email;

    int age; // Not annotated, will not be serialized

    User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

class JsonSerializer {
    static String toJson(Object obj) {
        Map<String, String> jsonMap = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                try {
                    Object value = field.get(obj);
                    jsonMap.put(annotation.name(), String.valueOf(value));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":")
                .append("\"").append(entry.getValue()).append("\",");
        }
        if (json.charAt(json.length() - 1) == ',') {
            json.setLength(json.length() - 1); // remove trailing comma
        }
        json.append("}");
        return json.toString();
    }
}

public class JsonSerializerMain {
    public static void main(String[] args) {
        User user = new User("nimish", "nimish@example.com", 23);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
