package leet_code;

import java.util.Arrays;

public class ReverseString {
    public static void reverseString(char[] s) {
        for (int i = 0; i < (s.length / 2); i++) {
            char first = s[i];

            if (first != s[s.length - i - 1]) {
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = first;
            }
        }
    }


    public static void reverseStringRecursive(char[] s) {
        reverseHelper(s, 0, s.length - 1);
    }

    public static void reverseHelper(char[] s, int p1, int p2) {
        if (p2 - p1 == 0 || p2 - p1 == -1) {
            return;
        }


        reverseHelper(s, p1 + 1, p2 - 1);

        if (s[p1] == s[p2]) {
            return;
        }

        char ref_p1 = s[p1];

        s[p1] = s[p2];
        s[p2] = ref_p1;
    }
}
