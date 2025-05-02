package Reflection;

import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }
}

class DynamicInvoke {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String methodName = sc.next();
        int a = sc.nextInt();
        int b = sc.nextInt();

        MathOperations obj = new MathOperations();
        Method method = MathOperations.class.getDeclaredMethod(methodName, int.class, int.class);
        Object result = method.invoke(obj, a, b);
        System.out.println(result);
    }
}
