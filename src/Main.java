import algorithms.BinarySearch;
import leet_code.MergeSortedArrays;
import leet_code.ReverseInteger;
import leet_code.ReverseString;
import leet_code.StrStr;

import java.util.Arrays;

import static algorithms.MoveZeros.moveZeroes;
import static algorithms.MoveZeros.smartMoveZeroes;
import static leet_code.LongestSubstring.lengthOfLongestSubstring;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[]{-1, 0, 5, 6, 8, 9, 12};
        smartMoveZeroes(list);
        System.out.println(list);

//        int[] list1 = new int[]{-1,0,0,3,3,3,0,0,0};
//        int[] list2 = new int[]{1,2,2};
//
//        MergeSortedArrays.merge(list1, 0, list2, 1);
//        System.out.println(Arrays.toString(list1));

//        char[] list1 = new char[]{'h','e','l','l','o'};
//        char[] list2 = new char[]{'H','a','n','n','a','h'};

//        ReverseString.reverseString(list2);

//        int a = -123;
//        ReverseInteger.reverse(a);

//        System.out.println(StrStr.strStr("mississippi", "issip"));

        lengthOfLongestSubstring("abcabcbb");

    }
}
