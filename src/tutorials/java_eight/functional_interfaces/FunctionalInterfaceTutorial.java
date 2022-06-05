package tutorials.java_eight.functional_interfaces;

import java.util.Arrays;

@FunctionalInterface
interface Drawable {
    String draw();

    default String drawDefault() {
        return "default draw";
    }
}

@FunctionalInterface
interface Writable {
    String write(String string);

    default String defaultWrite() {
        return "default write";
    }
}

class DrawingBook {
    private String value = "Rectangle";

    Drawable d1 = new Drawable() {
        String value = "Triangle";

        @Override
        public String draw() {
            return this.value + " is Drawing";
        }
    };

    /**
     * Inside lambda function scope is enclosing scope
     */
    Drawable d2 = () -> {
        String value = "Circle";
        return this.value + " is Drawing";
    };

    // TODO: Check this final case
//    public void writeSomething() {
//        String value1 = "Hello world";
//
//        Writable w = (p) -> {
//            String value1 = p;
//            return value1 + " is Drawing";
//        };
//    }
}

class FunctionalInterfaceTutorial {
    public static void main(String[] args) {
        DrawingBook drawingBook = new DrawingBook();

        System.out.println(drawingBook.d1.draw());
        System.out.println(drawingBook.d2.draw());

        int min1 = Arrays.stream(new int[]{1, 2, 3, 4, 5}).min().orElse(0);
    }
}
