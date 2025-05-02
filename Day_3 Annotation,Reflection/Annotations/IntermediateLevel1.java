package Annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTest {
    @LogExecutionTime
    void taskOne() {
        for (int i = 0; i < 1000000; i++);
    }

    @LogExecutionTime
    void taskTwo() {
        for (int i = 0; i < 10000000; i++);
    }

    void taskThree() {
        for (int i = 0; i < 100000000; i++);
    }
}

class IntermediateLevel1 {
    public static void main(String[] args) throws Exception {
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(test);
                long end = System.nanoTime();
                long duration = end - start;
                System.out.println("Method: " + method.getName() + ", Time Taken: " + duration + " ns");
            }
        }
    }
}
