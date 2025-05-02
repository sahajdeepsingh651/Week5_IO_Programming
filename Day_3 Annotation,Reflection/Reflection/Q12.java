package Reflection;
import java.lang.reflect.*;

class Tasks {
    void taskOne() {
        for (int i = 0; i < 1000000; i++);
    }

    void taskTwo() {
        for (int i = 0; i < 500000; i++);
    }
}

class ExecutionTimer {
    public static void main(String[] args) throws Exception {
        Tasks tasks = new Tasks();
        for (Method method : Tasks.class.getDeclaredMethods()) {
            long start = System.nanoTime();
            method.invoke(tasks);
            long end = System.nanoTime();
            System.out.println(method.getName() + " took " + (end - start) + " ns");
        }
    }
}
