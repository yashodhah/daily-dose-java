package sort;

import leet_code.MergeSortedArrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] list = new int[]{12, 11, 13, 5, 6};
//        InsertionSort.sort(list);

        int[] list1 = new int[]{-1,0,0,3,3,3,0,0,0};
        int[] list2 = new int[]{1,2,2};

        MergeSortedArrays.merge(list1, 0, list2, 1);
        System.out.println(Arrays.toString(list1));
    }
}
