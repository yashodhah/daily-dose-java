package dp;

public class Fibonacci {
    // 0,1,1,2,3,5,,,
    // recursion
    public static int calls = 0;
    public static long[] resolvedValues = new long[1000];

    public static void clearMeasurements() {
        calls = 0;
        resolvedValues = new long[1000];
    }

    /**
     * F0 = 0, F1 =1
     * @param n
     * @return
     */
    public static int recursionFib(int n) {
        calls++;

        if (n <= 1) {
            return n;
        }

        return recursionFib(n - 1) + recursionFib(n - 2);
    }

    public static long recursionFibOpt(int n) {
        calls++;

        if (n <= 1) {
            return n;
        }

        long i;
        long j;

        if (resolvedValues[n - 1] != 0) {
            i = resolvedValues[n - 1];
        } else {
            i = recursionFibOpt(n - 1);
        }

        if (resolvedValues[n - 2] != 0) {
            j = resolvedValues[n - 2];
        } else {
            j = recursionFibOpt(n - 2);
        }

        resolvedValues[n] = i + j;
        return i + j;
    }


}
