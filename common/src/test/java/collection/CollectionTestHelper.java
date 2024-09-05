package collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CollectionTestHelper {
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Employee implements Comparable<Employee> {
        String id;
        String dep;
        float salary;

        @Override
        public int compareTo(Employee otherEmployee) {
           return Double.compare(this.salary, otherEmployee.salary);
        }
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
        c.add(new Employee("chan", "hr", 10000));
        c.add(new Employee("mike", "it", 8000));
        c.add(new Employee("james", "it", 9000));
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

    public static LinkedList<Integer> getLinkedList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(101);

        return list;
    }

    public static LinkedList<Employee> getEmployeeLinkedList(){
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("chan", "hr", 10000));
        employees.add(new Employee("mike", "it", 8000));
        employees.add(new Employee("james", "it", 9000));
        return employees;
    }
}
