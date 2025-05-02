package Reflection;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

class Service {
    void serve() {
        System.out.println("Service Running");
    }
}

class Client {
    @Inject
    Service service;
}

class DIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.setAccessible(true);
                field.set(obj, dependency);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        injectDependencies(client);
        client.service.serve();
    }
}
