package leet_code;

public class ReverseInteger {
    public static int reverse(int x) {
        String reverseStr = String.valueOf(reverseString(String.valueOf(Math.abs(x)).toCharArray()));
        int out;

        try {
            out = Integer.parseInt(reverseStr);

            if (x < 0) {
                out *= -1;
            }
        } catch (Exception e) {
            out = 0;
        }

        return out;
    }


    public static char[] reverseString(char[] s) {
        for (int i = 0; i < (s.length / 2); i++) {
            char first = s[i];

            if (first != s[s.length - i - 1]) {
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = first;
            }
        }

        return s;
    }
}
