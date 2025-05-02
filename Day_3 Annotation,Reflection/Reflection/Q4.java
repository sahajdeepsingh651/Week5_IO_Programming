package Reflection;

import java.lang.reflect.*;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class DynamicallyCreateObject {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        Student student = (Student) constructor.newInstance("John");
        System.out.println(student.name);
    }
}
