import org.junit.jupiter.api.Test;

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
}
