package playground;

public class playground {
    static class A {
        private A() {
            System.out.println("Subclassed A in "+getClass().getName());
        }
    }

    static class B extends A {
        public B() {

        }
    }
    public static void main(String[] args) {
        new B();
    }
}
