package collection;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
