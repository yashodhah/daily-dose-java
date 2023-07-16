package utils;

public class LambdaUtils {

    public static Runnable runnableWrapper(Runnable runnable) {
        return () -> {
            try {
                runnable.run();
            } catch (Exception e) {
                System.err.println("Exception occured : " + e.getMessage());
            }
        };
    }

    public static <E extends Exception> Runnable runnableWrapper(Runnable runnable, Class<E> exClass) {
        return () -> {
            try {
                runnable.run();
            } catch (Exception e) {
                try {
                    E exCast = exClass.cast(e);
                    System.err.println("Exception occurred : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw e;
                }
            }
        };
    }

    public static Runnable throwingRunnableWrapper(ThrowingRunnable<Exception> runnable) {
        return () -> {
            try {
                runnable.run();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
