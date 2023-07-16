package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {

    }
}

class SingleThreadPool {
    private static ExecutorService singlePool = (ExecutorService) Executors.newSingleThreadExecutor();

    void submit(Runnable runnable) {
        singlePool.execute(runnable);
    }

    public static void main(String[] args) {
        SingleThreadPool sp = new SingleThreadPool();
        sp.submit(new MultiplierRunnable(1));
    }
}

class ExecutorServicePool {
    public static void main(String[] args) {
        ExecutorServicePool sp1 = new ExecutorServicePool();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
//            MultiplierCallable callable = new MultiplierCallable(ThreadLocalRandom.current().nextInt());
            MultiplierCallable callable = new MultiplierCallable(ThreadLocalRandom.current().nextInt() * ThreadLocalRandom.current().nextInt());

            Future<Integer> future = sp1.submit(callable);
            futures.add(future);
        }

        sp1.shutdown();

        for (Future<Integer> future : futures) {
            try {
                Integer result = future.get();
                System.out.println("Result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    void submit(Runnable runnable) {
        executorService.submit(runnable);
    }

    <T> Future<T> submit(Callable<T> callable) {
        return executorService.submit(callable);
    }

    void shutdown() {
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}


class MultiplierCallable implements Callable<Integer> {
    int number;

    public MultiplierCallable(int number) {
        this.number = number;
    }

    public Integer call() throws InvalidParameterException, InterruptedException {
        if (number < 0) {
            throw new InvalidParameterException("Number should be positive");
        }

        Thread.sleep(1000);
        return number * number;
    }
}

class MultiplierRunnable implements Runnable {
    int number;

    public MultiplierRunnable(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        if (number < 0) {
            return;
        }

        System.out.println(number * number);
    }
}