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
     *
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

    /**
     * Naive approach to cache the resolved data in global array
     *
     * @param n
     * @return
     */
    public static long recursionFibOpt(int n) {
        calls++;

        if (n <= 1) {
            return n;
        }


        if (resolvedValues[n] != 0) {
            return resolvedValues[n];
        }

        long i = recursionFibOpt(n - 1);
        long j = recursionFibOpt(n - 2);

        resolvedValues[n] = i + j;

        return i + j;
    }

    /**
     * Cache in a growing array
     */
    public static long dpFibonacci(int n) {
        long[] memoize = new long[n + 1];
        return dpFibonacciRecursive(n, memoize);
    }

    public static long dpFibonacciRecursive(int n, long[] memoize) {
        calls++;

        if (n <= 1) {
            return n;
        }

        if (memoize[n] != 0) {
            return memoize[n];
        }

        memoize[n] = dpFibonacciRecursive(n - 1, memoize) + dpFibonacciRecursive(n - 2, memoize);
        return memoize[n];
    }

}
