package leet_code.sliding_window;

import java.util.Set;

public class MaxVowels {
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int maxCount = 0;

        // calculate in the first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s, i)) {
                maxCount++;
            }
        }

        if (maxCount == k) {
            return maxCount;
        }

        // calculate while sliding the window. and removing what's being dropping from the window
        int count = maxCount;

        for (int i = k; i < s.length(); i++) {
            if (isVowel(s, i)) {
                count++;
            }

            if (isVowel(s, i - k)) {
                count--;
            }

            maxCount = Math.max(maxCount, count);

            if (maxCount == k) {
                break;
            }
        }

        return maxCount;
    }

    private boolean isVowel(String s, int i) {
        return vowels.contains(s.charAt(i));
    }

    public static void main(String[] args) {
        MaxVowels m = new MaxVowels();

        int count = m.maxVowels("tryhard", 4);
        System.out.println(count);
    }
}
