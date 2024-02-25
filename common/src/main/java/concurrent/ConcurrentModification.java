package concurrent;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

class WorkerA extends Thread {
    private CountDownLatch latch;

    private ArrayList<Integer> arr;

    public WorkerA(String name, CountDownLatch latch, ArrayList<Integer> arr) {
        this.latch = latch;
        this.arr = arr;
        setName(name);
    }

    @Override
    public void run() {
        try {
            System.out.printf("[ %s ] created, blocked by the latch...\n", getName());
            latch.await();
            System.out.printf("[ %s ] starts at: %s\n", getName(), Instant.now());

            for (int num : arr) {
                System.out.println(num);
                Thread.sleep(2000);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
            // handle exception
        }
    }
}


class WorkerB extends Thread {
    private CountDownLatch latch;

    private ArrayList<Integer> arr;

    public WorkerB(String name, CountDownLatch latch, ArrayList<Integer> arr) {
        this.latch = latch;
        this.arr = arr;

        setName(name);
    }

    @Override
    public void run() {
        try {
            System.out.printf("[ %s ] created, blocked by the latch...\n", getName());
            latch.await();
            System.out.printf("[ %s ] starts at: %s\n", getName(), Instant.now());

            Iterator<Integer> iterator = arr.iterator();

            while (iterator.hasNext()) {
                Integer number = iterator.next();

                // we are removing things using iterator here
                if (number == 3) {
                    iterator.remove();
                }

                System.out.println(number);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
            // handle exception
        }
    }
}

class ConcurrentModification {
    public static void main(String[] args) {

      failFast();
      failSafe();
    }

    static void failFast(){
        /**
         * ArrayList, HashMap from collection are fail-fast iterators.
         */
        ArrayList<Integer> arr = Stream.of(1, 2, 3, 4, 5)
                .collect(toCollection(ArrayList::new));

        CountDownLatch latch = new CountDownLatch(1);

        WorkerA workerA = new WorkerA("W1", latch, arr);
        WorkerB workerB = new WorkerB("W2", latch, arr);

        workerA.start();
        workerB.start();

        // latch is used to start them at the same time
        latch.countDown();
    }

    static void failSafe(){
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("First", 10);
        map.put("Second", 20);
        map.put("Third", 30);
        map.put("Fourth", 40);


        
    }
}




