package concurrent;

class Interruption {
    public static void main(String[] args) {
        Thread a = new Thread();
        a.stop();
    }
}
