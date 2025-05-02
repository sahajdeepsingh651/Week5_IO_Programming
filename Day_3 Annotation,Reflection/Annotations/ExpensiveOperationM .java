package Annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ExpensiveOperations {
    Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    int fibonacci(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result for: " + n);
            return cache.get(n);
        }

        int result;
        if (n <= 1) {
            result = n;
        } else {
            result = fibonacci(n - 1) + fibonacci(n - 2);
        }

        cache.put(n, result);
        System.out.println("Computed and cached result for: " + n);
        return result;
    }
}

 class Expensive {
    public static void main(String[] args) throws Exception {
        ExpensiveOperations operations = new ExpensiveOperations();
        Method method = ExpensiveOperations.class.getDeclaredMethod("fibonacci", int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            System.out.println("Result: " + method.invoke(operations, 5));
            System.out.println("Result: " + method.invoke(operations, 5)); // Should use cache
            System.out.println("Result: " + method.invoke(operations, 6));
        }
    }
}
