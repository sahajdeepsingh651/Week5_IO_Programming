package Reflection;

import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class HelloService implements Greeting {
    public void sayHello() {
        System.out.println("Hello World");
    }
}

class LoggingProxy {
    public static void main(String[] args) {
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            (obj, method, params) -> {
                System.out.println("Calling: " + method.getName());
                return method.invoke(new HelloService(), params);
            }
        );
        proxy.sayHello();
    }
}
