package concurrent.platform.synchronizaiton;

import helpers.CPUBoundTask;

public class Counter {
    private int c = 0;

    public void increment() {
        System.out.println(Thread.currentThread().getName() + "is incrementing the counter");
        c++;
    }

    public void decrement() {
        System.out.println(Thread.currentThread().getName() + "is decrementing the counter");
        CPUBoundTask.getNumberOfPrimes(10000 * c);
        c--;
    }

    public int value() {
        return c;
    }
}
