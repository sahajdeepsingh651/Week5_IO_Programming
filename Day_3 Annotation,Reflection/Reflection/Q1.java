package Reflection;

import java.lang.reflect.*;

class ClassInfo {
    public static void main(String[] args) throws ClassNotFoundException {
        String className = "java.util.ArrayList";
        Class<?> clazz = Class.forName(className);

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
    }
}
