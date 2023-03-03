import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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
