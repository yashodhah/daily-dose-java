package collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    @Test
    void enhancedIteratorLoopBackward(){
        List<String> list = CollectionTestHelper.getArrayList();
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();){
            System.out.println(it.previous());
        }
    }

    @Test
    void enhancedIteratorAdditionalOperations(){
        List<String> list = CollectionTestHelper.getArrayList();
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();){
            if (it.previous().equals("z")){
                it.add("*");
            } else if (it.previous().equals("a")){
                it.set("a*");
            }
        }

        Assertions.assertEquals(List.of("a*", "b", "c", "*", "z"), list);
    }

    @Test
    void linkedListBenefits (){
        List<String> linkedList1 = new LinkedList<>();
        Queue<String> linkedList2 = new LinkedList<>();
        LinkedList<String> linkedList3 = new LinkedList<>();
    }

    @Test
    void listSort(){
        List<CollectionTestHelper.Employee>
                employeeList = CollectionTestHelper.getEmployeeArrayList();

        System.out.println(employeeList.stream().map(e-> e.salary).collect(Collectors.toList()));
        Collections.sort(employeeList);
        System.out.println(employeeList.stream().map(e-> e.salary).collect(Collectors.toList()));
    }

}
