package Reflection;

import java.lang.reflect.*;

class Person {
    private int age = 30;
}

class AccessPrivateField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();

        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println(ageField.get(person));

        ageField.set(person, 35);
        System.out.println(ageField.get(person));
    }
}
