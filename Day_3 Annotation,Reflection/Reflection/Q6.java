package Reflection;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "Nimish Julka")
class Document {
}

class AnnotationReader {
    public static void main(String[] args) {
        Class<Document> clazz = Document.class;
        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println(author.name());
        }
    }
}
