package streams;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsInDepth {

    public static void main(String[] args) {
        streamCreation();
        streamReferencing();
        pipeline();
        lazyInvocation();
        streamReduction();
    }

    /**
     * If we need to introduce a terminal operation we can use that
     */
    private static void streamReduction() {

    }

    private static void lazyInvocation() {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");

        // Intermediate operations are not called if it is not needed by a terminal operation
        Stream<String> result = list.stream().filter(i -> {
            System.out.println("Filter called");
            return i.contains("2");
        });

        printStreamAsList(result);

        Optional<String> result1 = list.stream().filter(i -> {
            System.out.println("Filter called");
            return i.contains("2");
        }).map(i -> {
            System.out.println("Map called");
            return i.substring(1, 4);
        }).findFirst();

        System.out.println(result1);

        List<String> result2 = list.stream().filter(i -> {
            System.out.println("Filter called");
            return i.contains("2");
        }).map(i -> {
            System.out.println("Map called");
            return i.substring(1, 4);
        }).collect(Collectors.toList());

        System.out.println(result2);
    }


    private static void pipeline() {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        List<String> results = list.stream().skip(1).map(i -> i.substring(2, 4)).sorted().collect(Collectors.toList());

        System.out.println(results);
    }

    private static void streamReferencing() {
        /**
         * Streams can't be used again after a terminal operation, we can do something like this instead
         */
        List<Integer> filteredElements = Stream.of(1, 2, 3, 4, 5).filter(i -> i > 2).collect(Collectors.toList());
        Optional<Integer> anyElement = filteredElements.stream().findAny();
        Optional<Integer> firstElement = filteredElements.stream().findFirst();

        System.out.println(anyElement.get());
        System.out.println(firstElement.get());


        /**
         * Find any vs find first
         */

        List<String> list = Arrays.asList("A", "B", "C", "D", "E");

        Optional<String> result1 = list.stream().findAny();
        Optional<String> result2 = list.stream().parallel().findAny();
        Optional<String> result3 = list.stream().parallel().findFirst();

        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());

    }

    private static void streamCreation() {
        // Empty streams for handle null
        Stream emptyStream = Stream.empty();

        // Can create streams from any collection
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> collectionStream = collection.stream();

        // Streams from array
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> arrStream = Arrays.stream(arr);

        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

        // Infinite streams
        Stream<String> generatedStream = Stream.generate(() -> "YD").limit(10);
        Stream<Integer> iterateStream = Stream.iterate(2, x -> x + 2).limit(10);

        printStreamAsList(generatedStream);
        printStreamAsList(iterateStream);

        // Stream of primitives
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        LongStream longStream = LongStream.range(1, 200);

        // Stream of strings
        IntStream charStream = "abc".chars();
        printIntStreamAsList(charStream);

        // NIO streams
        try {
            Path path = Paths.get("test.txt");
            Stream<String> streamOfStrings = Files.lines(path);
            Stream<String> streamWithCharset =
                    Files.lines(path, Charset.forName("UTF-8"));

            // TODO: Seems like both the same
            printStreamAsList(streamOfStrings);
            printStreamAsList(streamWithCharset);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void printStreamAsList(Stream stream) {
        stream.forEach(val -> System.out.print(val + " | "));
        System.out.println();
    }

    private static void printIntStreamAsList(IntStream stream) {
        stream.forEach(val -> System.out.print(val + " | "));
        System.out.println();
    }
}
