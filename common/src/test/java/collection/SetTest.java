package collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SetTest{
    @Test
    void basicOperations(){
        Set set = new HashSet();

        set.add(null);
        Map<String, List<CollectionTestHelper.Employee>> employeeDepMap =
                CollectionTestHelper.getEmployeeArrayList()
                        .stream()
                        .collect(Collectors.groupingBy(CollectionTestHelper.Employee::getDep));

        // strong contract over equal and hash code for maps
        set.add(Optional.of(employeeDepMap));
        set.add(Optional.of(employeeDepMap));

        Assertions.assertEquals(2, set.size());
    }
}
