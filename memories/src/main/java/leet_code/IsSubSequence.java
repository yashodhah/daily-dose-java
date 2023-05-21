package leet_code;

public class IsSubSequence {
    public boolean isSubsequence_1(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        if (s.length() > t.length()) {
            return false;
        }

        /**
         * 0 <= s.length <= 100
         * 0 <= t.length <= 10**4
         * s and t consist only of lowercase English letters.
         */

        int fwdRef = 0;
        String refStr = "";

        for (int i = 0; i < s.length(); i++) {
            if (fwdRef == t.length()) {
                break;
            }

            for (int j = fwdRef; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    fwdRef = j + 1;
                    refStr += t.charAt(j);
                    break;
                }
            }
        }

        return refStr.equals(s);
    }

    public boolean isSubsequence_2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        if (s.length() > t.length()) {
            return false;
        }

        int i = 0;

        /**
         *  loop through the big array ( worst case 10,000)
         *  if found exist early
         */
        for (int j = 0; j < t.length(); j++) {
            if (t.charAt(j) == s.charAt(i)) {
                if (i == (s.length() - 1)) {
                    return true;
                }

                i++;
            }
        }

        return false;
    }

    public boolean isSubsequence(String s, String t){
        int n = s.length();
        int m = t.length();

        int i = 0; // -> traverse small string (s)
        int j = 0; // -> traverse larger string (t)

        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == n;
    }

    public boolean isSubsequence_chatGPT(String s, String t) {
        int index = -1; // Keeps track of the last index found in string t

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false; // Character not found in string t
            }
        }

        return true; // All characters of s found in t
    }



    public static void main(String[] args) {
        IsSubSequence subSequence = new IsSubSequence();
        System.out.println(subSequence.isSubsequence("abc", "ahbgdc"));
    }
}
