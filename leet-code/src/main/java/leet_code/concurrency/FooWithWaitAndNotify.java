package leet_code.concurrency;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

class FooMonitor implements IFoo {
    @Override
    public synchronized void first(Runnable printFirst) throws Exception {
        printFirst.run();
    }

    @Override
    public synchronized void second(Runnable printSecond) throws Exception {
        printSecond.run();
    }

    @Override
    public synchronized void third(Runnable printThird) throws Exception {
        printThird.run();
    }
}

/**
 * Use instance monitor
 */
class FooWithWaitAndNotify implements IFoo {
    private boolean firstDone;
    private boolean secondDone;

    public FooWithWaitAndNotify() {
        firstDone = false;
        secondDone = false;
    }

    public synchronized void first(Runnable printFirst) {
        printFirst.run();
        firstDone = true;
        notifyAll();
    }

    /**
     * A thread can also wake up without being notified, interrupted,
     * or timing out, a so-called spurious wakeup.
     * While this will rarely occur in practice, applications must guard against it.
     * That's why we are using a while loop here so ot will check before proceeding
     * @param printSecond
     */
    public synchronized void second(Runnable printSecond) {
        System.out.println("Inside second");

        try {
            /**
             * you may have access to the lock now thread bro, but unfortunately you can't
             * do shit until I change this firstDone state.
             * you may now release the lock.
             * Don't worry someone will notify you via this object lock.
             */
            while (!firstDone) {
                System.out.println("Waiting inside second");
                wait();
            }

            printSecond.run();
            secondDone = true;
            notifyAll();
        } catch (InterruptedException e) {

        }
    }

    public synchronized void third(Runnable printThird) {
        System.out.println("Inside third");

        try {
            while (!secondDone) {
                System.out.println("Waiting inside third");
                wait();
            }

            printThird.run();
            notifyAll();
        } catch (Exception e) {

        }
    }
}

/**
 * Use a single monitor
 */
class FooWithWaitAndNotifyWithObjectMonitor implements IFoo {
    private boolean firstDone = false;
    private boolean secondDone = false;
    private Object monitor1 = new Object();

    public void first(Runnable printFirst) {
        synchronized (monitor1) {
            printFirst.run();
            firstDone = true;

            monitor1.notify();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (monitor1) {
            System.out.println("Inside second");

            while (!firstDone) {
                System.out.println("Waiting inside second");
                wait();
            }

            printSecond.run();
            secondDone = true;

            monitor1.notify();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (monitor1) {
            System.out.println("Inside third");

            while (!secondDone) {
                System.out.println("Waiting inside third");
                wait();
            }

            printThird.run();
            notifyAll();
        }
    }
}

class FooSemaphore implements IFoo {
    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s1.release(); // release 1 permit
    }

    public void second(Runnable printSecond) throws InterruptedException {
        /**
         * blocking until some other threads release a permit on this semaphore
         * tryAcquire would return false if no permits available
         */
        s1.acquire();
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        printThird.run();
    }
}

class FooLatch implements IFoo {
    private CountDownLatch l1 = new CountDownLatch(1);
    private CountDownLatch l2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        l1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        l1.await();
        printSecond.run();
        l2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        l2.await();
        printThird.run();
    }
}

interface IFoo {
    public void first(Runnable printFirst) throws Exception;

    public void second(Runnable printSecond) throws Exception;

    public void third(Runnable printThird) throws Exception;
}

class Executor {
    public static void main(String[] args) {
        IFoo fooMonitor = getFoo("mon_wn");

        List<Thread> threads = createThreads(fooMonitor);
        runDynamicExecutionOrder(threads, 10);
    }

    private static List<Thread> createThreads(IFoo fooMonitor) {
        Thread threadA = new Thread(() -> {
            try {
                fooMonitor.first(() -> System.out.println("* first "));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                fooMonitor.second(() -> System.out.println("* second "));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                fooMonitor.third(() -> System.out.println("* third "));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return Arrays.asList(threadA, threadB, threadC);
    }

    private static void runDynamicExecutionOrder(List<Thread> threads, int cycles) {
        Random random = new Random();
        Collections.shuffle(threads, random);

        threads.forEach(Thread::start);
    }

    private static IFoo getFoo(String type) {
        if (type.equals("mon")) {
            return new FooMonitor();
        } else if (type.equals("mon_wn")) {
            return new FooWithWaitAndNotify();
        } else if (type.equals("sem")) {
            return new FooSemaphore();
        } else if (type.equals("latch")) {
            return new FooLatch();
        } else {
            throw new RuntimeException("Invalid type");
        }
    }
}
