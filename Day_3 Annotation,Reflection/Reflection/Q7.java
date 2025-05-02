package Reflection;
import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "12345";
}

class ModifyStaticField {
    public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);
        field.set(null, "98765");
        System.out.println(field.get(null));
    }
}
