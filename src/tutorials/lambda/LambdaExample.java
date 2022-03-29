package tutorials.lambda;

@FunctionalInterface
interface Drawable {
    void draw();

    default void drawHard() {
        System.out.println("Draw hard");
    }
}

interface Printable {
    String print(String name);
}

interface Addable {
    int add(int a, int b);
}

class LambdaExample {
    public static void main(String[] args) {
        int width = 10;

        //without lambda, Drawable implementation using anonymous class
        Drawable d1 = new Drawable() {
            public void draw() {
                System.out.println("Drawing " + width);
            }

            public void drawHard() {
                System.out.println("Draw hard inside anonymous");
            }
        };

        Drawable d2 = () -> {
            System.out.println("Drawing " + width * 2);
        };

        Printable p2 = name -> "Hello " + name;

        Addable a1 = (a, b) -> a - b;

        d1.draw();
        d1.drawHard();
        d2.draw();

        System.out.println(p2.print("YD"));
        System.out.println(a1.add(1, 2));
    }
}
