import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadFactory;

public class VirtualThreadTests {

    @Test
    public void start(){
        final int numberOfThreads = 1_000_000;

        for (int i = 0; i < numberOfThreads; i++) {

            Thread virtualThread = Thread.ofVirtual().unstarted(new BlockedThread(i));

            virtualThread.start();

            String str = String.format("Java 21 virtual thread number %s is running.", i);

            System.out.println(str);

        }
    }
}
