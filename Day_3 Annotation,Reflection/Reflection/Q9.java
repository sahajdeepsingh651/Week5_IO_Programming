package Reflection;

import java.lang.reflect.*;

class User {
    String username = "nimish";
    int score = 100;
}

class JsonSerializer {
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            json.append("\"").append(field.getName()).append("\":\"").append(field.get(obj)).append("\",");
        }
        json.setLength(json.length() - 1);
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        System.out.println(toJson(user));
    }
}