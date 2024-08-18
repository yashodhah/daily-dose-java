package streams;

import nl.jqno.equalsverifier.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    private int counter;

    private void wasCalled() {
        counter++;
    }


    @Test
    public void test() {
        List<String> list = Arrays.asList("abc1”, “abc2”, “abc3");
        Stream<String> test = list.stream().filter(e-> {
            wasCalled();
            return e.contains("2");
        });

        Assertions.assertTrue(counter == 0);
    }
}
