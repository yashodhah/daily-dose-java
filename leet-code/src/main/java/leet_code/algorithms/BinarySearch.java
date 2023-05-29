package leet_code.algorithms;

import aop.tracing.Trace;

@Trace
public class BinarySearch {
    public int basicSearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int idx = -1;
        int startIdx = 0;
        int endIdx = nums.length - 1;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (nums[midIdx] == target) {
                idx = midIdx;
                break;
            }

            if (nums[midIdx] < target) {
                startIdx = midIdx + 1;
            } else {
                endIdx = midIdx - 1;
            }
        }

        return idx;
    }

    /**
     * If not found return the appropriate index of the given array to put in to
     * while preserve the sorted array
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int idx = -1;
        int startIdx = 0;
        int endIdx = nums.length - 1;

        while (startIdx <= endIdx) {
            int midIdx = startIdx + (endIdx - startIdx) / 2;

            if (nums[midIdx] == target) {
                idx = midIdx;
                return idx;
            }

            if (nums[midIdx] < target) {
                startIdx = midIdx + 1;
            } else {
                endIdx = midIdx - 1;
            }
        }

        if (endIdx < 0) {
            idx = 0;
        } else {
            idx = startIdx;
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int a = new BinarySearch().basicSearch(arr, 9);

        System.out.println(a);
    }
}
