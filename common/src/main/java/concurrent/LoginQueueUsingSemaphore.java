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

    class LoginTask implements Callable {
        @Override
        public Object call() throws Exception {
            performLogin();
            return null;
        }

        void performLogin() throws InterruptedException {
            trace("Available permit : " + semaphore.availablePermits());
            trace("Number of threads waiting to acquire: " + semaphore.getQueueLength());

            if (semaphore.tryAcquire(10000, TimeUnit.MILLISECONDS)) {
                try {
                    Thread.sleep(getRandomNumber());
                    trace("finished critical section");
                } finally {
                    // can use semaphore.release(10) to release 10 permits, initial slot is not a indication of some threshold.
                    semaphore.release();
                }
            }
        }

        long getRandomNumber() {
            return ThreadLocalRandom.current().nextLong(1000, 10000);
        }
    }

    private void trace(String message) {
        System.out.println(Thread.currentThread().getName() + " : " + message);
    }

    public void runSim() {
        int users = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(users);

        IntStream.range(0, users).forEach(user -> executorService.submit(new LoginTask()));
        executorService.shutdown();
    }

    public static void main(String[] args) {
        LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(10);
        loginQueue.runSim();
    }
}


