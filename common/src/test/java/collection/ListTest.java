package collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
        LinkedList<String> linkedList = new LinkedList<>();
    }





}
