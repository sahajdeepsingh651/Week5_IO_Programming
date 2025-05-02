import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectTasks {
    @Todo(task = "Implement user authentication", assignedTo = "Nimish", priority = "HIGH")
    void authModule() {
        System.out.println("Working on auth module...");
    }

    @Todo(task = "Add payment gateway integration", assignedTo = "Riya")
    void paymentModule() {
        System.out.println("Working on payment module...");
    }

    void completedModule() {
        System.out.println("This module is already completed.");
    }
}

class Main {
    public static void main(String[] args) {
        Method[] methods = ProjectTasks.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println();
            }
        }

        ProjectTasks pt = new ProjectTasks();
        pt.authModule();
        pt.paymentModule();
        pt.completedModule();
    }
}
