import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Util {
    /**
     * Java 9 feature
     */
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

    public static void main(String[] args) {
        new Util().optionalToStream();
    }
}
