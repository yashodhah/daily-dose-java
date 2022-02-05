package leet_code;

import java.util.HashMap;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Boolean> charMap = new HashMap();

        int remainCharLen = s.length();
        int maxSoFar = 0;

        int startIdx = -1;

        while (maxSoFar < remainCharLen) {
            startIdx++;
            String str = "";

            int innerRefIdx = startIdx;

            while (charMap.get(s.charAt(innerRefIdx)) == null && innerRefIdx != s.length() - 1) {
                charMap.put(s.charAt(innerRefIdx), true);

                str += s.charAt(innerRefIdx);
                innerRefIdx++;
            }

            charMap.clear();

            if (maxSoFar < str.length()) {
                maxSoFar = str.length();
            }

            remainCharLen = getRemainCharLen(s, startIdx);
        }

        return maxSoFar;
    }

    public static int getRemainCharLen(String s, int startIdx) {
        return s.length() - startIdx - 1;
    }
}
