package leet_code;

import java.util.HashMap;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        HashMap<Character, Boolean> charMap = new HashMap();

        int remainCharLen = s.length();
        int maxSoFar = 0;
        int startIdx = -1;

        while (maxSoFar < remainCharLen) {
            startIdx++;

            int innerRefIdx = startIdx;
            int counter = 0;
            charMap.clear();

            while (innerRefIdx < s.length() && charMap.get(s.charAt(innerRefIdx)) == null) {
                charMap.put(s.charAt(innerRefIdx), true);

                counter++;
                innerRefIdx++;
            }

            if (maxSoFar < counter) {
                maxSoFar = counter;
            }

            remainCharLen = getRemainCharLen(s, startIdx);
        }

        return maxSoFar;
    }

    public static int getRemainCharLen(String s, int startIdx) {
        return s.length() - startIdx - 1;
    }
}
