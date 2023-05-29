package leet_code;

import leet_code.utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Need more optimization
public class PhoneNumberCombination {
    Map<String, List<String>> ref = new HashMap();

    public List<String> letterCombinations(String digits) {
        init();

        if (digits.isEmpty()) {
            return new ArrayList<>();
        } else if (digits.length() == 1) {
            return ref.get(digits);
        }

        return getAllPermutation(digits);
    }

    private List<String> getAllPermutation(String digits) {
        int divPoint = digits.length() / 2;

        String s1 = digits.substring(0, divPoint);
        String s2 = digits.substring(divPoint);

        if (digits.length() == 2) {
            return getPermutations(ref.get(s1), ref.get(s2));
        } else {
            if (digits.length() == 3) {
                return getPermutations(ref.get(s1), getAllPermutation(s2));
            } else {
                return getPermutations(getAllPermutation(s1), getAllPermutation(s2));
            }
        }
    }

    private List<String> getPermutations(List<String> l1, List<String> l2) {
        List<String> out = new ArrayList();

        for (String s1 : l1) {
            for (String s2 : l2) {
                out.add(s1.concat(s2));
            }
        }

        return out;
    }

    private void init() {
        ref.put("2", List.of("a", "b", "c"));
        ref.put("3", List.of("d", "e", "f"));
        ref.put("4", List.of("g", "h", "i"));
        ref.put("5", List.of("j", "k", "l"));
        ref.put("6", List.of("m", "n", "o"));
        ref.put("7", List.of("p", "q", "r", "s"));
        ref.put("8", List.of("t", "u", "v"));
        ref.put("9", List.of("w", "x", "y", "z"));
    }

    public static void main(String[] args) {
        PhoneNumberCombination clz = new PhoneNumberCombination();

        List l1= clz.letterCombinations("");
        Util.listInfo(l1);
    }
}