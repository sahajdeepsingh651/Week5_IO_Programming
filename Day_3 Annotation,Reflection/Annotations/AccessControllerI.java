package Annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AccessController {
    @RoleAllowed("ADMIN")
    void adminPanel() {
        System.out.println("Accessing admin panel...");
    }

    @RoleAllowed("USER")
    void userDashboard() {
        System.out.println("Accessing user dashboard...");
    }
}

public class AccessControllerI{
    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER"; // Simulate current user role

        AccessController controller = new AccessController();
        Method[] methods = AccessController.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = method.getAnnotation(RoleAllowed.class);
                if (role.value().equals(currentUserRole)) {
                    method.invoke(controller);
                } else {
                    System.out.println("Access Denied to method: " + method.getName());
                }
            }
        }
    }
}
