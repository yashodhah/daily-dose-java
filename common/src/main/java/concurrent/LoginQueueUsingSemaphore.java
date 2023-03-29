package concurrent;

import java.util.concurrent.*;
import java.util.stream.IntStream;

class LoginQueueUsingSemaphore {
    private Semaphore semaphore;

    public LoginQueueUsingSemaphore(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    void logout() {
        semaphore.release();
    }

    int availableSlots() {
        return semaphore.availablePermits();
    }

    class WierdTask implements Callable {
        @Override
        public Object call() throws Exception {
            executeCriticalSection();
            return null;
        }

        void executeCriticalSection() throws InterruptedException {
            trace("Available permit : " + semaphore.availablePermits());
            trace("Number of threads waiting to acquire: " + semaphore.getQueueLength());

            if (semaphore.tryAcquire(10000, TimeUnit.MILLISECONDS)) {
                try {
                    Thread.sleep(getRandomNumber());
                    trace("finished critical section");
                } finally {
                    semaphore.release();
                }
            }
        }

        long getRandomNumber() {
            return ThreadLocalRandom.current().nextLong(1000, 10000);
        }
    }

    public void trace(String message) {
        System.out.println(Thread.currentThread().getName() + " : " + message);
    }

    public void runSim() {
        int users = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(users);

        IntStream.range(0, users).forEach(user -> executorService.submit(new WierdTask()));
        executorService.shutdown();
    }

    public static void main(String[] args) {
        LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(10);
        loginQueue.runSim();
    }
}


