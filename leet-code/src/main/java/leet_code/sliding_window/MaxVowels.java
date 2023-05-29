package leet_code.sliding_window;

import java.util.Set;

public class MaxVowels {
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int start = 0;
        int maxSoFar = 0;

        while (s.length() - start > k - 1) {
            VowelInfo vowelInfo = getNuOfVowels(s, start, k);

            if (vowelInfo.count() > maxSoFar) {
                maxSoFar = vowelInfo.count();
            }

            if (vowelInfo.count() == k || start == s.length() - k) {
                break;
            }

            start = Math.min(s.length() - k, vowelInfo.startIdx());
        }

        return maxSoFar;
    }

    private VowelInfo getNuOfVowels(String s, int start, int window) {
        int count = 0;
        int idxLastVowel = -1;
        int end = start + window;

        String sub = s.substring(start, end);

        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);

            if (vowels.contains(c)) {
                count++;

                if (i != 0 && idxLastVowel < 0) {
                    idxLastVowel = i;
                }
            }
        }

        if (idxLastVowel < 0) {
            idxLastVowel = end;
        } else {
            idxLastVowel = start + idxLastVowel;
        }

        return new VowelInfo(count, idxLastVowel);
    }

    public static void main(String[] args) {
        MaxVowels m = new MaxVowels();
        int count = m.maxVowels("abciiidef", 3);
        System.out.println(count);
    }
}

record VowelInfo(int count, int startIdx) {
}
