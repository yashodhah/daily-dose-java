package algorithms;

import org.junit.Assert;

import static algorithms.SquaresOfSortedArr.getLastMinusIdx;
import static algorithms.SquaresOfSortedArr.sortedSquares;
import static leet_code.ReverseString.reverseString;

public class Test {
    @org.junit.Test
    public void shouldGetTheFirstMinusCorrect() {
        int[] nums1 = new int[]{-4, -1, 0, 3, 10};
        int[] nums2 = new int[]{3, 10, 121};
        int[] nums3 = new int[]{0, 3, 10, 121};
        int[] nums4 = new int[]{-7, -6, -5, -4, -1};
        int[] nums5 = new int[]{-1, 0, 3, 10};
        int[] nums6 = new int[]{-7, -3, 2, 3, 11};

        Assert.assertEquals(1, getLastMinusIdx(nums1));
        Assert.assertEquals(-1, getLastMinusIdx(nums2));
        Assert.assertEquals(-1, getLastMinusIdx(nums3));
        Assert.assertEquals(4, getLastMinusIdx(nums4));
        Assert.assertEquals(0, getLastMinusIdx(nums5));
        Assert.assertEquals(1, getLastMinusIdx(nums6));
    }

    @org.junit.Test
    public void shouldGetTheArrRight() {
        int[] nums1 = new int[]{-4, -1, 0, 3, 10};
        int[] nums2 = new int[]{-7, -3, 2, 3, 11};
        int[] nums3 = new int[]{0, 3, 10, 121};
        int[] nums4 = new int[]{-7, -6, -5, -4, -1};
        int[] nums5 = new int[]{-1, 0, 3, 10};

//        Assert.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(nums1));
        Assert.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(nums2));
    }

    @org.junit.Test
    public void shouldReverseString() {
        char[] char1 = new char[]{'t', 'e', 's', 't'};
        char[] char2 = new char[]{'y', 'a', 's', 'h', 'o', 'd', 'h', 'a'};


        reverseString(char2);
        System.out.println(char1);
    }
}
