package tutorials.functional_interfaces;

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
}

class FunctionalInterfaceTutorial {
    public static void main(String[] args) {
        DrawingBook drawingBook = new DrawingBook();

        System.out.println(drawingBook.d1.draw());
        System.out.println(drawingBook.d2.draw());
    }
}
