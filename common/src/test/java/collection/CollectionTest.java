package collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;



public class CollectionTest {

    @Test
    void shouldBeAbleAToConvertTheCollectionType(){
        Collection<String> c = new ArrayList<>();
        c.add("123");
        c.add("234");
        c.add("123");

        Set<String> s = new HashSet<>(c);

        Assertions.assertTrue(c.size() == 3);
        Assertions.assertTrue(s.size() ==2);
    }

    @Test
    void traverseACollection(){
        // TODO: Use annotation based resolving to get a collection based implementation
//        Collection<String> c = CollectionTestHelper.getArrayList();
        Collection<String> c = CollectionTestHelper.getHashSet();


        /**
         * using aggregation operations like forEach, filter .....
         * streams are not like collection as they are not data structures
         * They just create pipelines from sources like collection, Arrays ...
         * We can perform stream operations on a stream
         */
        String joined = c.stream().filter(e-> !e.contains("z")).collect(Collectors.joining(":"));
        Assertions.assertTrue(joined.equals("a:b:c"));

        /**
         * Or we can use the for-each construct
         */
        StringBuilder sb = new StringBuilder();
        for(String str : c){
            if(!str.equals("z")) {
                sb.append(str);
            }
        }

        Assertions.assertEquals("abc",  sb.toString());

        /**
         * Or we can use an iterator
         * When to use iterator over for-each construct
         * - when we want to call the remove operation
         * - iterate over multiple collections in parallel ?
         *
         * TODO: Study more on structural modification in array lists while traversing
         */
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("z")){
                it.remove();
            }
        }

        Assertions.assertEquals(3,  c.size());
    }

    @Test
    void usageOfFailFastIterator(){
        Assertions.assertThrows(ConcurrentModificationException.class, ()-> {
            Collection<String> c = CollectionTestHelper.getHashSet();

            Iterator<String> it = c.iterator();
            while (it.hasNext()) {
                String str = it.next();
                c.add(str + "test");
            }
        });
    }


    @Test
    void usageOfConcurrentCollection(){
        Collection<String> c = new CopyOnWriteArraySet<>(CollectionTestHelper.getHashSet());

        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            String str = it.next();
            c.add(str + "test");
        }

        System.out.println("collection size after iteration: " + c.size());
    }


    void collectionStaticMethods(){
        Collections.unmodifiableList(CollectionTestHelper.getArrayList());
        List.of("key", "value");
    }
}
