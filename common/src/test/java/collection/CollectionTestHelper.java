package collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CollectionTestHelper {
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Employee {
        String id;
        String dep;
        float salary;
    }

    public static ArrayList<String> getArrayList() {
        ArrayList<String> c = new ArrayList<>();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("z");
        return c;
    }

    public static ArrayList<Employee> getEmployeeArrayList() {
        ArrayList<Employee> c = new ArrayList<>();
        c.add(new Employee("mike", "it", 8000));
        c.add(new Employee("james", "it", 9000));
        c.add(new Employee("houchinchon", "hr", 10000));
        return c;
    }



    public static Set<String> getHashSet() {
        Set<String> c = new HashSet<>();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("z");
        return c;
    }
}
