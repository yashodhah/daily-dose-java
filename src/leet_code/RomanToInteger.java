package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 */
class RomanToIntegerSolution {
    final String[] symbols = new String[]{"I", "V", "X", "L", "C", "D", "M"};
    final Map<String, Integer> map = new HashMap<>();

    public int romanToInt(String s) {
        initBasicSymbolValues();

        if (s == null || s.isEmpty()) {
            // validate input
        }

        String[] inputChars = s.split("");

        // Validate input with symbols

        int finalValue = 0;

        int i = 0;

        while (i < inputChars.length) {
            int value;
            String char1 = inputChars[i];

            if (i != inputChars.length - 1) {
                String char2 = inputChars[i + 1];

                if (char1.equals("I") && (char2.equals("V") || char2.equals("X")) ||
                        char1.equals("X") && (char2.equals("L") || char2.equals("C")) ||
                        char1.equals("C") && (char2.equals("D") || char2.equals("M"))
                ) {
                    value = map.get(char1 + char2);
                    finalValue += value;

                    i += 2;

                    continue;
                }
            }

            value = map.get(char1);
            finalValue += value;
            i++;
        }

        return finalValue;
    }

    private void initBasicSymbolValues() {
        map.put(String.valueOf('I'), 1);
        map.put(String.valueOf('V'), 5);
        map.put(String.valueOf('X'), 10);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put(String.valueOf('L'), 50);
        map.put(String.valueOf('C'), 100);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put(String.valueOf('D'), 500);
        map.put(String.valueOf('M'), 1000);
        map.put("CD", 400);
        map.put("CM", 900);
    }
}

class Jedi {
    /* Constructor A */
    Jedi(String name, String species) {
        this(name, species, false);
    }

    /* Constructor B */
    Jedi(String name, String species, boolean followsTheDarkSide) {
        System.out.println("Calls");
    }
}


public class RomanToInteger {
    public static void main(String[] args) {
        Jedi jedi = new Jedi("YD", "homo");

//        for (int i = 0; i < 10; i = ++i) {
//            System.out.println(i);
//            System.out.println("Hello World!");
//        }
//        RomanToIntegerSolution romanToIntegerSolution = new RomanToIntegerSolution();
//
//        System.out.println(romanToIntegerSolution.romanToInt("MCMXCIV"));
    }
}
