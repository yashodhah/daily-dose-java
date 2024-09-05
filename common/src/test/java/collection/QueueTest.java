package collection;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    @Test
    void LinkedListIsAQueue() throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(45);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            Thread.sleep(1000);
        }
    }

    @Test
    void QueueOperations(){
        Queue<Integer> intList = CollectionTestHelper.getLinkedList();
        // add operations
        intList.add(1);
        intList.offer(1);
        //examine
        intList.element();
        intList.peek();
        // remove
        intList.remove();
        intList.poll();
    }
}
