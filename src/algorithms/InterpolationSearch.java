package algorithms;

public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (arr[right] != arr[left] && target >= arr[left] && target <= arr[right]) {
            // estimate mid
            int mid = left + ((target - arr[left]) * (right - left) / (arr[right] - arr[left]));

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (target == arr[left]) {
            return left;
        }

        return -1;
    }
}
