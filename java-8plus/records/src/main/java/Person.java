import java.util.Objects;

public record Person(String name, String address) {
    public static boolean IS_PERSON;
    public Person {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }

    public Person(String name) {
        this(name, "Unknown");
    }

    public static Person unnamed(String address) {
        return new Person("Unnamed", address);
    }
}