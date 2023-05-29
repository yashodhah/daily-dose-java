package leet_code.sliding_window;

// TODO

/**
 * runtime is 5ms
 */
public class MaxSubArr {


    /**
     * n == nums.length
     * 1 <= k <= n <= 10**5
     * -104 <= nums[i] <= 10**4
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        long sumSoFar = findSum(nums, k);
        long maxSoFar = sumSoFar;

        int i = 0;

        while (nums.length - k > i) {
            sumSoFar += (nums[i + k] - nums[i]);

            if (sumSoFar > maxSoFar) {
                maxSoFar = sumSoFar;
            }

//            maxSoFar = Math.max(maxSoFar, sumSoFar);

            i++;
        }

        return maxSoFar / 1.0 / k;
    }

    public long findSum(int[] nums, int k) {
        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        MaxSubArr maxSubArr = new MaxSubArr();

        int[] ints = {1, 12, -5, -6, 50, 3};
        double a = maxSubArr.findMaxAverage(ints, 4);
        System.out.println(a);


        int[] ints1 = {3, 3, 4, 3, 0};
        double b = maxSubArr.findMaxAverage(ints1, 3);
        System.out.println(b);

    }
}
