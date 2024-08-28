package concurrent.platform.low_level;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class ThreadBasicsTest {

    @Test
    void interrupt_scenario_1() {
        Thread thread = new Thread(this::simpleTask);
        thread.start();
        thread.interrupt();
    }

    @Test
    void interrupt_scenario_2() throws InterruptedException {
        Thread thread1 = new Thread(this::someWierdTask);
        thread1.start();
        thread1.interrupt();
        thread1.join();
    }

    void simpleTask(){
        System.out.println("hello hello");

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }


    void someWierdTask() {
        while (true){
            System.out.println("doing some wierd shit");

            System.out.println("let's see whether I have been fired or not");

            if (Thread.interrupted()){
                System.out.println("oh !! no !!");
                return;
            }

            System.out.println("resuming some wierd shit again");

        }
    }
}
