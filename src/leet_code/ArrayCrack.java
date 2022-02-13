package leet_code;

import java.util.HashMap;
import java.util.Map;

public class ArrayCrack {
    static class ArrayIdx {
        public static int offset = (int) Math.pow(10, 9);
        public static int nu_of_buckets = 100; // total 20

        static Map<Integer, Map<Integer, Boolean>> positiveNumIdx = new HashMap<>();
        static Map<Integer, Map<Integer, Boolean>> negativeNumIdx = new HashMap<>();
        static boolean isZero = false;

        public static void clearResources() {
            positiveNumIdx.clear();
            negativeNumIdx.clear();
            isZero = false;
        }

        public static boolean isItemAvailable(int num) {
            if (num > offset) {
                return false;
            }

            if (num > 0) {
                return checkAvailabilityOnIdx(num, positiveNumIdx);
            } else if (num < 0) {
                return checkAvailabilityOnIdx(Math.abs(num), negativeNumIdx);
            } else {
                if (isZero) {
                    return false;
                }

                isZero = true;
            }

            return false;
        }

        private static boolean checkAvailabilityOnIdx(int num, Map<Integer, Map<Integer, Boolean>> index) {
            int bucketNum = getBucketNumber(num);

            if (index.get(bucketNum) == null) {
                index.put(bucketNum, new HashMap<>());
            }

            if (index.get(bucketNum).get(num) != null && index.get(bucketNum).get(num) == true) {
                return true;
            }

            index.get(bucketNum).put(num, true);
            return false;
        }

        private static int getBucketNumber(int value) {
            int bucketNum = value / nu_of_buckets;

            if (value % nu_of_buckets > 0) {
                bucketNum++;
            }

            return bucketNum;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        ArrayIdx.clearResources();

        for (int num : nums) {
            if (ArrayIdx.isItemAvailable(num)) {
                return true;
            }
        }

        return false;
    }
}

