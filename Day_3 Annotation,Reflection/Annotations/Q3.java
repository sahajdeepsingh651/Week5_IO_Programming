package Annotations;
import java.util.ArrayList;
import java.util.List;

class WarningDemo {
    @SuppressWarnings("unchecked")
    void addItems() {
        List list = new ArrayList();
        list.add("Item 1");
        list.add("Item 2");

        for (Object item : list) {
            System.out.println(item);
        }
    }
}

class Q3{
    public static void main(String[] args) {
        WarningDemo demo = new WarningDemo();
        demo.addItems();
    }
}
