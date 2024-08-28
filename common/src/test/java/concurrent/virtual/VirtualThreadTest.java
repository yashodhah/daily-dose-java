package concurrent.virtual;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadTest {

    @Test
    void threadCreation() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread thread = Thread.ofVirtual()
                    .start(() -> System.out.println("Hello " + finalI));
            thread.join(0);
        }
    }

    @Test
    void threadCreation1() throws InterruptedException {
        Thread.Builder builder = Thread.ofVirtual()
                .name("MyThread");
        Runnable task = () -> System.out.println("Hello from virtual thread");

        Thread t = builder.start(task);
        System.out.println("Thread t name: " + t.getName());
        t.join();
    }

    @Test
    void threadCreation2() throws InterruptedException {
        Thread.Builder builder = Thread.ofVirtual().name("worker-", 0);
        Runnable task = () -> {
            System.out.println("Thread ID: " + Thread.currentThread().threadId());
        };

// name "worker-0"
        Thread t1 = builder.start(task);
        t1.join();
        System.out.println(t1.getName() + " terminated");

// name "worker-1"
        Thread t2 = builder.start(task);
        t2.join();
        System.out.println(t2.getName() + " terminated");
    }

    @Test
    void threadCreation4() throws ExecutionException, InterruptedException {
        try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?> future = myExecutor.submit(() -> System.out.println("Running virtual thread"));
            future.get();
            System.out.println("Task completed");
            // ...
        }
    }
}
