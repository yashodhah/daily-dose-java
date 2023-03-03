package data_structures;

import java.util.Set;

public class DatStructures {
    void newSet() {
        Set<String> strKeySet = Set.of("key1", "key2", "key3");
        strKeySet.add("key2"); // can;t add to immutable set
    }

    public static void main(String[] args) {
        new DatStructures().newSet();
    }
}
