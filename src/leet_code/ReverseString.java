package leet_code;

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
}
