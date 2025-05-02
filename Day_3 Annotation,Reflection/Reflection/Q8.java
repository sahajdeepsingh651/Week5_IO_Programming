package Reflection;

import java.lang.reflect.*;
import java.util.*;

class Person {
    String name;
    int age;
}

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            if (properties.containsKey(field.getName())) {
                field.setAccessible(true);
                field.set(obj, properties.get(field.getName()));
            }
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Nimish");
        data.put("age", 23);
        Person p = toObject(Person.class, data);
        System.out.println(p.name + " " + p.age);
    }
}
