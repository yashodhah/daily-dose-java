package concurrent;

import java.util.concurrent.*;

class ConcurrentPlayground {
    public static void main(String[] args) {
        ConcurrentPlayground cp = new ConcurrentPlayground();


        cp.start();
        cp.execute();
        cp.executorService();
    }

    public void start(){
        Thread t = new Thread(new RunnableTask());
        t.start();
    }

    public void executorService() {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // TODO: Learn on termination and shits

        Future future1 = executor.submit(new RunnableTask());
        Future future2 = executor.submit(new CallableTask(12));

        /**
         * When we call future.get it will throw execution exception which includes
         * the original exception
         */
        try {
            Future future3 = executor.submit(new CallableTask(-1));
            Integer result = (Integer) future3.get();
        } catch (ExecutionException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // futures
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000l);
            return "Hello world";
        });

        try {
            String str = future.get();
            System.out.println(str);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        trace();
        Executor executor = new ExecutorInvoker();

        executor.execute(() -> {
            trace();
        });
    }


    private void trace() {
        long threadId = Thread.currentThread().getId();
        System.out.println(threadId);
    }
}

class ExecutorInvoker implements Executor {
    @Override
    public void execute(Runnable r) {
        r.run();
    }
}

class RunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Very important but bump runnable task");
    }
}

class CallableTask implements Callable<Integer> {
    int number;

    public CallableTask(int number) {
        this.number = number;
    }

    public Integer call() throws InvalidParameterException {

        if (number < 0) {
            throw new InvalidParameterException("Number should be positive");
        }

        return number * number;
    }
}

class InvalidParameterException extends Exception {
    public InvalidParameterException(String message) {
        super(message);
    }
}
