//package leet_code;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class ArrayCrack {
////    static class ArrayIdx {
////        public static int offset = (int) Math.pow(10, 9);
////        public static int nu_of_buckets = 100; // total 20
////
////        static Map<Integer, Map<Integer, Boolean>> positiveNumIdx = new HashMap<>();
////        static Map<Integer, Map<Integer, Boolean>> negativeNumIdx = new HashMap<>();
////        static boolean isZero = false;
////
////        public static void clearResources() {
////            positiveNumIdx.clear();
////            negativeNumIdx.clear();
////            isZero = false;
////        }
////
////        public static boolean isItemAvailable(int num) {
////            if (num > offset) {
////                return false;
////            }
////
////            if (num > 0) {
////                return checkAvailabilityOnIdx(num, positiveNumIdx);
////            } else if (num < 0) {
////                return checkAvailabilityOnIdx(Math.abs(num), negativeNumIdx);
////            } else {
////                if (isZero) {
////                    return false;
////                }
////
////                isZero = true;
////            }
////
////            return false;
////        }
////
////        private static boolean checkAvailabilityOnIdx(int num, Map<Integer, Map<Integer, Boolean>> index) {
////            int bucketNum = getBucketNumber(num);
////
////            if (index.get(bucketNum) == null) {
////                index.put(bucketNum, new HashMap<>());
////            }
////
////            if (index.get(bucketNum).get(num) != null && index.get(bucketNum).get(num) == true) {
////                return true;
////            }
////
////            index.get(bucketNum).put(num, true);
////            return false;
////        }
////
////        private static int getBucketNumber(int value) {
////            int bucketNum = value / nu_of_buckets;
////
////            if (value % nu_of_buckets > 0) {
////                bucketNum++;
////            }
////
////            return bucketNum;
////        }
////    }
//
//    static class ArrayIndexByIdx {
//        public static int offset = (int) Math.pow(10, 9);
//        public static int nu_of_buckets = 100; // total 20
//
//        // bucket_no : <value: index>
//        static Map<Integer, Map<Integer, Integer>> positiveNumIdx = new HashMap<>();
//        static Map<Integer, Map<Integer, Integer>> negativeNumIdx = new HashMap<>();
//        static Integer zero = null;
//
//        public static void clearResources() {
//            positiveNumIdx.clear();
//            negativeNumIdx.clear();
//            zero = null;
//        }
//
//        public static void indexArray(int num, int arrayIdx) {
//            if (num > offset) {
//                return;
//            }
//
//            if (num > 0) {
//                updateIdx(num, arrayIdx, positiveNumIdx);
//            } else if (num < 0) {
//                updateIdx(Math.abs(num), arrayIdx, negativeNumIdx);
//            } else {
//                zero = arrayIdx;
//            }
//        }
//
//        public static Integer getIdx(int remainNum, int currentNum, int currentIdx) {
//            if (remainNum > 0) {
//                return checkAvailabilityOnIdx(remainNum, positiveNumIdx, currentNum, currentIdx);
//            } else if (remainNum < 0) {
//                return checkAvailabilityOnIdx(Math.abs(remainNum), negativeNumIdx, currentNum, currentIdx);
//            } else {
//                return zero;
//            }
//        }
//
//        private static Integer checkAvailabilityOnIdx(int num, Map<Integer, Map<Integer, Integer>> index, int current, int currentIdx) {
//            int bucketNum = getBucketNumber(num);
//
//            if (index.get(bucketNum) == null) {
//                index.put(bucketNum, new HashMap<>());
//            }
//
//            if (index.get(bucketNum).get(num) != null) {
//                return index.get(bucketNum).get(num);
//            }
//
//            indexArray(current, currentIdx);
//
//            return null;
//        }
//
//        private static void updateIdx(int num, int arrayIdx, Map<Integer, Map<Integer, Integer>> index) {
//            int bucketNum = getBucketNumber(num);
//
//            if (index.get(bucketNum) == null) {
//                index.put(bucketNum, new HashMap<>());
//            }
//
//            index.get(bucketNum).put(num, arrayIdx);
//        }
//
//        private static int getBucketNumber(int value) {
//            int bucketNum = value / nu_of_buckets;
//
//            if (value % nu_of_buckets > 0) {
//                bucketNum++;
//            }
//
//            return bucketNum;
//        }
//    }
//
//    public int[] twoSum(int[] nums, int target) {
//        ArrayIndexByIdx.clearResources();
//
//        for (int i = 0; i < nums.length; i++) {
//            ArrayIndexByIdx.indexArray(nums[i], i);
//        }
//
//        int[] out = new int[2];
//
//        for (int i = 0; i < nums.length; i++) {
//            int j = nums[i];
//            int r = target - j;
//
//            if (ArrayIndexByIdx.getIdx(r) != null && ArrayIndexByIdx.getIdx(r) != i) {
//                out[0] = i;
//                out[1] = ArrayIndexByIdx.getIdx(r);
//
//                break;
//            }
//        }
//
//        return out;
//    }
//
//    public int[] twoSumOptimization(int[] nums, int target) {
//        ArrayIndexByIdx.clearResources();
//        int[] out = new int[2];
//
//        for (int i = 0; i < nums.length; i++) {
//            int j = nums[i];
//            int r = target - j;
//
//            if (ArrayIndexByIdx.getIdx(r) != null && ArrayIndexByIdx.getIdx(r) != i) {
//                out[0] = i;
//                out[1] = ArrayIndexByIdx.getIdx(r);
//
//                break;
//            }
//        }
//
//        return out;
//    }
//
//
////    public boolean containsDuplicate(int[] nums) {
////        ArrayIdx.clearResources();
////
////        for (int num : nums) {
////            if (ArrayIdx.isItemAvailable(num)) {
////                return true;
////            }
////        }
////
////        return false;
////    }
//}
//
