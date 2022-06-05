package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * DB : Bottom up approach
 * Base Cases :
 * n = 1 => 1
 * n = 2 => 2
 */
class ClimbingStairs {
        Map<Integer, Integer> prevSteps = new HashMap<>();
        int nuOfFunctionCalls = 0;

        public int climbStairs(int i) {
            nuOfFunctionCalls++;

            if (i <= 0 || i > 45) {
                throw new RuntimeException("Not supported");
            }

            if (i <= 2) {
                return i;
            }

            if (prevSteps.get(i) != null) {
                return prevSteps.get(i);
            }

            prevSteps.put(i, climbStairs(i - 1) + climbStairs(i - 2));
            return prevSteps.get(i);
        }
}

class AlgoRunner {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.println(climbingStairs.climbStairs(45));
        System.out.println(climbingStairs.nuOfFunctionCalls);
    }
}

