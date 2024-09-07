package helpers;

public class CPUBoundTask {
    public static void getNumberOfPrimes(int numberOfPrimes) {
        int count = 0;
        long number = 2;

        while (count < numberOfPrimes) {
            if (isPrime(number)) {
                count++;
            }
            number++;
        }

//        System.out.println("number of primes : "  + count);
    }

    // Helper method to check if a number is prime
    public static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
