package dp;

public class ClimbingStairsBol {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] lastStepStatics = {1, 1};
        return generateStepsR(n, 2, lastStepStatics);
    }

    private static int generateStepsR(int n, int lastStep, int[] lastStepStatics) {
        int numOfOnes = getNumberOfOnes(lastStepStatics);
        int numOfTwos = getNumberOfTwos(lastStepStatics);

        if (lastStep == n) {
            return numOfOnes + numOfTwos;
        }

        setNumberOfOnes(lastStepStatics, numOfOnes + numOfTwos);
        setNumberOfTwos(lastStepStatics, numOfOnes);

        lastStep++;

        return generateStepsR(n, lastStep, lastStepStatics);
    }

    private static int getNumberOfOnes(int[] lastStepStatics) {
        return lastStepStatics[0];
    }

    private static int setNumberOfOnes(int[] lastStepStatics, int value) {
        return lastStepStatics[0] = value;
    }

    private static int getNumberOfTwos(int[] lastStepStatics) {
        return lastStepStatics[1];
    }

    private static int setNumberOfTwos(int[] lastStepStatics, int value) {
        return lastStepStatics[1] = value;
    }
}
