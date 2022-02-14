package dp;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {
    private static HashMap<String, Integer> coinSelectionStat = new HashMap<>();
    private int minExchanges = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        int[] sortedArr = trimTillHighestMin(coins, amount);

        int j = sortedArr.length - 1;

        while (j <= 0) {
            int possiblePathLen = getPathLen(sortedArr, amount, 0);

            sortedArr[j] = 0;
            j--;
        }

        return 0;
    }


    // TODO: Need to implement tree traverse
    public int getPathLen(int[] coins, int amount, int len) {
        int highestMin = getHighestMinimum(coins, amount);
        Integer lenFromCache = coinSelectionStat.get(getKey(amount, highestMin));

        if (lenFromCache != null) {
            return len + lenFromCache;
        }

        return 0;

    }

    private static String getKey(int i, int j) {
        return i + "~" + j;
    }


    /**
     * @param arr = maximum length 12
     * @param ref
     * @return
     */
    private int getHighestMinimumIdx(int[] arr, int ref) {
        int maxSoFar = -1;
        int idx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxSoFar) {
                maxSoFar = arr[i];
                idx = i;
            }
        }

        return idx;
    }

    private int getHighestMinimum(int[] arr, int ref) {
        int maxSoFar = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxSoFar) {
                maxSoFar = arr[i];
            }
        }

        return maxSoFar;
    }

    private int[] trimTillHighestMin(int[] arr, int ref) {
        Arrays.sort(arr);
        int idx = getHighestMinimumIdx(arr, ref);

        int[] numArray = new int[idx + 1];

        int i = 0;
        while (i <= idx) {
            numArray[i] = arr[i];
            i++;
        }

        return numArray;
    }
}


