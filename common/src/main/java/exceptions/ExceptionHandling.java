package exceptions;
class ExceptionHandling {
    void doSomeIllegalShit() throws Exception {
        try {
            System.out.println("try");
            throw new RuntimeException("runtime error");
        } catch (Exception e) {
            System.out.println("catch");
            throw new Exception(e);
        }
    }

    public static void main(String[] args) throws Exception {
        ExceptionHandling eh = new ExceptionHandling();
        eh.doSomeIllegalShit();
    }
}

class Player {
    void getStat() throws PlayerException {
    }
}

class FootBallPlayer extends Player {
    @Override
    void getStat() {
    }
}

class PlayerException extends Exception {

}

class FootballException extends PlayerException {

}

class WierdException extends Exception {

}
