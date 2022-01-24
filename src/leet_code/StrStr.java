package leet_code;

public class StrStr {
    public static int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int firstOccurrence = -1;
        int lastFirsOccurrence = -1;

        if (needle.length() == 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return firstOccurrence;
        }

        while (i <= haystack.length()) {
            if (j == needle.length()) {
                break;
            }

            if (i == haystack.length()) {
                firstOccurrence = -1;
                break;
            }

            if (haystack.charAt(i) == needle.charAt(0)) {
                lastFirsOccurrence = i;
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                if (firstOccurrence < 0) {
                    firstOccurrence = i;
                }

                j++;
            } else {
                if (lastFirsOccurrence > -1 && firstOccurrence > -1) {
                    i = lastFirsOccurrence - 1;
                }

                firstOccurrence = -1;
                j = 0;
            }

            i++;
        }

        return firstOccurrence;
    }
}
