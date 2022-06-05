package playground;

class A {
    private A() {
    }

    public static A getInstance() {
        return new A();
    }
}
