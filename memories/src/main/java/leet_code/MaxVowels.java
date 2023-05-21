package leet_code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxVowels {
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int start = 0;
        int maxSoFar = 0;

        while (s.length() - start > k - 1) {
            VowelInfo vowelInfo = getNuOfVowels(s, start, start + k);

            if (vowelInfo.count() > maxSoFar) {
                maxSoFar = vowelInfo.count();
            }

            if (vowelInfo.count() == k) {
                break;
            }

//            start = vowelInfo.startIdx();
            start++;
        }

        return maxSoFar;
    }

    private VowelInfo getNuOfVowels(String s, int start, int end) {
        int count = 0;
//        int idxLastVowel = -1;

//        if (end > s.length()) {
//            start = start - (s.length() - end);
//        }

        String sub = s.substring(start, end);

        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);

            if (vowels.contains(c)) {
                count++;

//                if (idxLastVowel < 0) {
//                    idxLastVowel = i;
//                }
            }
        }

//        if (idxLastVowel < 0) {
//            idxLastVowel = end;
//        } else {
//            idxLastVowel = start + idxLastVowel;
//        }

        return new VowelInfo(count, -1);
    }

    public static void main(String[] args) {
        MaxVowels m = new MaxVowels();
        int count = m.maxVowels("abciiidef", 3);

        System.out.println(count);
    }
}

record VowelInfo(int count, int startIdx) {
}
