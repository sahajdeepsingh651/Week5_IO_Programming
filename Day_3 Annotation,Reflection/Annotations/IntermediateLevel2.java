package Annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    String username;

    User(String username) {
        this.username = username;
        validate();
    }

    void validate() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);
                try {
                    String value = (String) field.get(this);
                    if (value != null && value.length() > maxLength.value()) {
                        throw new IllegalArgumentException("Field '" + field.getName() + "' exceeds max length of " + maxLength.value());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        User user1 = new User("nimish");
        System.out.println("User 1 created: " + user1.username);

        User user2 = new User("verylongusername"); // Will throw exception
        System.out.println("User 2 created: " + user2.username);
    }
}
