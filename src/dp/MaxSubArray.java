package dp;

class MaxSubArraySolution {
    int[] indexHolders = new int[]{-1, -1};

    public int maxSubArray(int[] nums) {
        int maxSumSoFar = Integer.MIN_VALUE;
        int sumSoFar = 0;

        for (int i = 0; i < nums.length; i++) {
            sumSoFar = nums[i] + sumSoFar;

            if (sumSoFar < 0) {
                if (sumSoFar > maxSumSoFar) {
                    maxSumSoFar = sumSoFar;
                }

                sumSoFar = 0;

                continue;
            }

            if (sumSoFar > maxSumSoFar) {
                maxSumSoFar = sumSoFar;
            }
        }

        return maxSumSoFar;
    }
}

class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArraySolution maxSubArraySolution = new MaxSubArraySolution();
        System.out.println(maxSubArraySolution.maxSubArray(new int[]{-2, -3, -1, -5, 4}));
    }
}




