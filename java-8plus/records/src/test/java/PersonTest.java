import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void givenNullAddress_whenCreateObjects_shouldThrow(){
        Person person = new Person("null colla", null);
    }

    @Test
    public void givenOnlyName_whenCreateObjects_shouldThrow(){
        Person person = new Person("null colla");

        assertEquals("Unknown", person.address());
    }

    @Test
    public void givenValidNameAndAddress_whenGetNameAndAddress_thenExpectedValuesReturned() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        Person person = new Person(name, address);

        assertEquals(name, person.name());
        assertEquals(address, person.address());
    }

    @Test
    public void givenSameNameAndAddress_whenHashCode_thenPersonsEqual() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        Person person1 = new Person(name, address);
        Person person2 = new Person(name, address);

        assertEquals(person1.hashCode(), person2.hashCode());
    }

}
