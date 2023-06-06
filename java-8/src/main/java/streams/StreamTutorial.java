package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTutorial {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("One", "OneAndOnly", "Derek", "Change", "factory", "justBefore", "Italy", "Italy", "Thursday");

//        aggregateOperations(list);
        streamsAndParallelStreams(list);


    }

    private static void streamsAndParallelStreams(List<String> list) {
        list.forEach(s -> {
            System.out.println(Thread.currentThread().getName() + " | " + s);
        });

        System.out.println();

        list.stream().parallel().forEach(s -> {
            System.out.println(Thread.currentThread().getName() + " | " + s);
        });
    }

    private static void aggregateOperations(List<String> list) {
        List<String> filtered = list.stream().filter(val -> val.length() > 3).collect(Collectors.toList());
        printList(filtered);


        List<String> mapped = list.stream().map(val -> val + " Mapped").collect(Collectors.toList());
        printList(mapped);

        List<String> mappedLimit = list.stream().limit(4).map(val -> val + " Mapped").collect(Collectors.toList());
        printList(mappedLimit);

        // sort random in string and print
        new Random().ints().limit(10).sorted().forEach(System.out::println);

        printList(list);
    }

    private static void printList(List list) {
        System.out.println(String.join(", ", list));
    }
}
