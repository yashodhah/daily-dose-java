package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * Counter implementation using Semaphores by
 * using a semaphore with exactly 1 slot
 */
public class Counter {
    private Semaphore mutex;
    private int count;

    Counter() {
        mutex = new Semaphore(1);
        count = 0;
    }

    void increment() throws InterruptedException {
        mutex.acquire();
        this.count += 1;
        Thread.sleep(1000);
        mutex.release();
    }

    public int getCount() {
        return count;
    }

    boolean hasQueuedThreads() {
        return mutex.hasQueuedThreads();
    }
}

class Simulator {
    void runSim() throws InterruptedException {
        int count = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        Counter counter = new Counter();
        IntStream.range(0, count).forEach(user -> executorService.execute(() -> {
            try {
                counter.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        executorService.shutdown();

        System.out.println(counter.hasQueuedThreads());

        Thread.sleep(10000);

        System.out.println(counter.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        new Simulator().runSim();
    }
}
