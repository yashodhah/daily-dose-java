package collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AggregateOperationsTest {



    /**
     * Collection based aggregations
     */

    @Test
    void toMap(){
        Map<String, List<CollectionTestHelper.Employee>> employeeDepMap =
        CollectionTestHelper.getEmployeeArrayList()
                .stream()
                .collect(Collectors.groupingBy(CollectionTestHelper.Employee::getDep));

        Assertions.assertEquals(2, employeeDepMap.get("it").size());

        Map<String, Double> employeeSalaryMap =
                CollectionTestHelper.getEmployeeArrayList()
                        .stream()
                        .collect(Collectors.groupingBy(
                                CollectionTestHelper.Employee::getDep, Collectors.summingDouble(CollectionTestHelper.Employee::getSalary)));

        Assertions.assertEquals(17000, employeeSalaryMap.get("it"));

    }
}
