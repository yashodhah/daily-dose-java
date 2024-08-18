package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CollectionTestHelper {
    public static ArrayList<String> getArrayList() {
        ArrayList<String> c = new ArrayList<>();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("z");
        return c;
    }

    public static Set<String> getHashSet() {
        Set<String> c = new HashSet<>();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("z");
        return c;
    }
}
