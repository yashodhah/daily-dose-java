package leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Palindrome {
    /**
     * WRONNNNG!!!!
     */
    static class PalindromeQueue {
        static List<String> list = new ArrayList<>();

        public static void add(String s) {
            if (list.size() == 0) {
                list.add(s);
            } else if (list.get(list.size() - 1).equals(s)) {
                list.remove(list.size() - 1);
            } else if (list.size() > 1 && list.get(list.size() - 2).equals(s)) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            } else {
                list.add(s);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        String parsedStr = getParsedStr(s);
        int mid;

        if (s.length() % 2 == 0) {
            mid = s.length() / 2;
        }

        return false;

    }

    private static String getParsedStr(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);
    }
}
