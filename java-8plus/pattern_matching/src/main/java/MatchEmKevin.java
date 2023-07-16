import org.junit.Test;

public class MatchEmKevin {

    void match(Object obj) {
        // String s is injected here
        if (obj instanceof String s) {
            int length = s.length();
            System.out.println(length);
        }
    }

    @Test
    public void test (){
        match("test");
    }
}
