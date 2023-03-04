import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class UtilTests {
    List<Integer> someIntList = new ArrayList<>();

    public UtilTests() {
        someIntList.add(1);
        someIntList.add(2);
        someIntList.add(3);
        someIntList.add(4);
    }

    void optionalToStream() {
        List<Optional> listOfOptionals = new ArrayList<>();
        listOfOptionals.add(Optional.empty());

        List<String> filteredList = (List<String>) listOfOptionals.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

    }

    /**
     * Java 9 feature
     * Immutable set
     */
    void getNewSet() {
        Set<String> strKeySet = Set.of("key1", "key2", "key3");
        strKeySet.add("key2"); // can;t add to immutable set
    }

    /**
     * Java 11 feature
     * String features
     */
    void stringOperations() {
        String multilineString = "No matter what \n \n I'm gonna \n WIN !!";
        List<String> strList = multilineString.lines().filter(line -> !line.isEmpty()).map(String::strip).collect(Collectors.toList());
        System.out.println(strList);
    }

    /**
     * Java 11 feature
     * predicate
     */
    void predicateNotMethod() {
        String multilineString = "No matter what \n \n I'm gonna \n WIN !!";
        List<String> strList = multilineString.lines().filter(Predicate.not(String::isBlank)).map(String::strip).collect(Collectors.toList());
        System.out.println(strList);
    }


    /**
     * Since java 11
     */
    @Test
    void collectionToArray() {
        List sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArr = (String[]) sampleList.toArray(String[]::new);

        System.out.println(Arrays.toString(sampleArr));
    }

    /**
     * Var can be used uniformly in both local and lambda context
     */
    @Test
    void localVariableSyntaxForLambda() {
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String str = sampleList.stream().map((var x) -> x.toUpperCase()).collect(Collectors.joining(","));

        System.out.println(str);
    }

    @Test
    public void whenModifyCopyOfList_thenThrowsException() {
        List<Integer> intList = List.copyOf(someIntList);
        assertThrows(UnsupportedOperationException.class, () -> intList.add(2));
    }

    @Test
    public void whenModifyToUnmodifiableList_thenThrowsException() {
        List<Integer> evenList = someIntList.stream().filter(x -> x % 2 == 0).collect(Collectors.toUnmodifiableList());
        assertThrows(UnsupportedOperationException.class, () -> evenList.add(6));
    }
}
