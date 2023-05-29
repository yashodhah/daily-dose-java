package leet_code;

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int initialPointer = 0;
        int arrLen = m + n;

        for (int i = 0; i < n; i++) {
            int num = nums2[i];

            for (int j = initialPointer; j <= m; j++) {
                if (nums1[j] == 0 && j == m) {
                    for (int l = j; l < arrLen; l++) {
                        nums1[l] = nums2[i];
                        i++;
                    }

                    return;
                }

                if (num < nums1[j]) {
                    int k = m;

                    if (nums1[k] == 0) {
                        while (k > j) {
                            nums1[k] = nums1[k - 1];
                            k--;
                        }

                        nums1[j] = num;
                        initialPointer = j + 1;
                        m++;
                    }

                    break;
                }
            }
        }
    }
}
