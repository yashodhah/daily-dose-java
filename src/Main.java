import algorithms.BinarySearch;
import leet_code.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static algorithms.MoveZeros.moveZeroes;
import static algorithms.MoveZeros.smartMoveZeroes;
import static leet_code.LongestSubstring.lengthOfLongestSubstring;
import static leet_code.Palindrome.isPalindrome;

public class Main {
    public static void main(String[] args) {
//        int[] list = new int[]{-1, 0, 5, 6, 8, 9, 12};
//        smartMoveZeroes(list);
//        System.out.println(list);

//        int[] list1 = new int[]{-1,0,0,3,3,3,0,0,0};
//        int[] list2 = new int[]{1,2,2};
//
//        MergeSortedArrays.merge(list1, 0, list2, 1);
//        System.out.println(Arrays.toString(list1));

        char[] list1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] list2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};

        ReverseString.reverseStringRecursive(list2);

//        int a = -123;
//        ReverseInteger.reverse(a);

//        System.out.println(StrStr.strStr("mississippi", "issip"));

//        lengthOfLongestSubstring("au");

//        TwoSomeAdvanced arrayCrack = new TwoSomeAdvanced();
//        arrayCrack.twoSum(new int[]{-1, -2, -3, -4, -5}, -8);

//        int[] list = new int[]{1, 0, 5, 6, 8, 9, 12};
//
//        System.out.println(solution(list));

    }

    public static int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }

        Map<Integer, Boolean> numMapper = new HashMap<>();

        for (int i : A) {
            numMapper.put(i, true);
        }

        int i = 1;

        while (true) {

            if (numMapper.get(i) == null) {
                return i;
            }

            i++;
        }
    }
}
