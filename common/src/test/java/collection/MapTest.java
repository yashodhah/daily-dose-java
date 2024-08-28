package collection;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MapTest {

    @Test
    void test (){
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key", "value");

        System.out.println(map.get("key"));

        Map<String, String> map1 = new LinkedHashMap<>();
    }
}
