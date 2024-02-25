package leet_code.sliding_window;

import java.util.Set;

public class BolMaxVowels {
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int startIdx = 0;
        int maxSoFar = 0;

        while (s.length() > startIdx + k - 1) {
            VowelInfo vowelInfo = getNuOfVowels(s, startIdx, k);

            if (vowelInfo.count() > maxSoFar) {
                maxSoFar = vowelInfo.count();
            }

            if (vowelInfo.count() == k || startIdx + k == s.length()) {
                break;
            }

            // in case of next start idx overlap the string length
            startIdx = Math.min(s.length() - k, vowelInfo.nextStartIdx());
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
        BolMaxVowels m = new BolMaxVowels();

        int count = m.maxVowels("tryhard", 4);
        System.out.println(count);
    }
}

record VowelInfo(int count, int nextStartIdx) {
}
