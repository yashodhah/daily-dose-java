package algorithms;

public class SquaresOfSortedArr {
    public static int[] sortedSquares(int[] nums) {
        int lastMinusIdx = getLastMinusIdx(nums);

        if (lastMinusIdx >= 0) {
            int startIdx = lastMinusIdx + 1;

            for (int j = lastMinusIdx; j >= 0; j--) {
                int key = Math.abs(nums[j]);

                int i;
                for (i = startIdx; (i < nums.length && nums[i] < key); i++) {
                    nums[i - 1] = nums[i];
                }

                nums[i - 1] = key;
                startIdx--;
            }
        }


        for (int k = 0; k < nums.length; k++) {
            nums[k] = (int) Math.pow(nums[k], 2);
        }

        return nums;
    }

    public static int getLastMinusIdx(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[right] < 0) {
            return right;
        }

        if (nums[left] >= 0) {
            return -1;
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == 0) {
                return mid - 1;
            } else if (nums[mid] > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }
}
