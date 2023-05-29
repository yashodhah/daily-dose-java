package concurrent;

class Volatile {

    private static int number;
    private static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            System.out.print(number + " ");
        }
    }

    /**
     * Main thread start new thread and change values.
     * If these threads are schedule in separate cores the reader thread may not get the ache updates done by
     * the main thread.
     *
     * Some wierd re-ordering done in caching to enhance performance ??
     *
     * To ensure that updates to the variables correctly propagate to the
     * other threads mark the variables as volatile.
     *
     * In a multithreaded application
     * 1.Mutual exclusion - synchronized
     * 2.Visibility - volatile
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        new Reader().start();

        number = 42;
        ready = true;
    }
}
