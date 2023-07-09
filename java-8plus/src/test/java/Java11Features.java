import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Java11Features {

    @Test
    void stringMagics(){
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";

        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::trim)
                .collect(Collectors.toList());

        System.out.println(lines);

    }

    @Test
    void collectionToArr(){
        List sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = (String[]) sampleList.toArray(String[]::new);

//        assert(sampleArray).containsExactly("Java", "Kotlin");
    }

}
