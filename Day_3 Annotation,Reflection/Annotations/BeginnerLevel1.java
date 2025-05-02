import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class ServiceManager {
    @ImportantMethod
    void startService() {
        System.out.println("Starting service...");
    }

    @ImportantMethod(level = "MEDIUM")
    void stopService() {
        System.out.println("Stopping service...");
    }

    void logService() {
        System.out.println("Logging service activity...");
    }
}

class Main {
    public static void main(String[] args) {
        Method[] methods = ServiceManager.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod imp = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + imp.level());
            }
        }

        ServiceManager manager = new ServiceManager();
        manager.startService();
        manager.stopService();
        manager.logService();
    }
}
