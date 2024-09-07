package concurrent.platform.synchronizaiton;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Simulator {
    void runSim() throws InterruptedException {
        int count = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        Counter counter = new Counter();
        IntStream.range(0, count).forEach(i -> executorService.execute(() -> {
            if (i % 3 == 0 ){
                counter.increment();
            } else {
                counter.decrement();
            }
        }));

        executorService.shutdown();

        System.out.println(counter.value());
    }

    public static void main(String[] args) throws InterruptedException {
        new Simulator().runSim();
    }
}
