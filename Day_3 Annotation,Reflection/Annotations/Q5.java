package Annotations;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class IssueTracker {
    @BugReport(description = "NullPointerException on line 15")
    @BugReport(description = "ArrayIndexOutOfBoundsException on edge case")
    void processIssues() {
        System.out.println("Processing issues...");
    }
}

class Q5 {
    public static void main(String[] args) throws Exception {
        Method method = IssueTracker.class.getMethod("processIssues");
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReport[] reports = method.getAnnotation(BugReports.class).value();
            for (BugReport report : reports) {
                System.out.println("Bug: " + report.description());
            }
        }

        IssueTracker tracker = new IssueTracker();
        tracker.processIssues();
    }
}
