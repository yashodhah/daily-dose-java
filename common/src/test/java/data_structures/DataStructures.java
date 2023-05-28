package data_structures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataStructures {
    @Test
    void newSet() {
        Set<String> strKeySet = Set.of("key1", "key2", "key3");
        assertThrows(UnsupportedOperationException.class, ()-> strKeySet.add("key2"));
    }

    @Test
    void newList() {
        List<String> strList = List.of("key1", "key2", "key3");
        assertThrows(UnsupportedOperationException.class, ()-> strList.add("key2"));
    }

    @Test
    void copyOfNam_notPossibleToModify(){
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(4);
        a.add(6);

        List<Integer> list = List.copyOf(a);
        assertThrows(UnsupportedOperationException.class, ()-> list.add(8));
    }

    @Test
    void streamsCollectors_asUnmodifiable(){
        List<Integer> list = getIntList().stream().map(i-> i + 2).collect(Collectors.toUnmodifiableList());
        assertThrows(UnsupportedOperationException.class, ()-> list.add(8));
    }

    private List<Integer> getIntList(){
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(4);
        a.add(6);

        return a;
    }
}
