package leet_code;

import java.util.HashMap;

public class DiverseString {
    public String solution(int A, int B, int C) {
        int maxSize = A + B + C;


        if (maxSize < 0 || A > 100 || B > 100 || C > 100) {
            return "";
        }

        int consecutive_a_count = 0;
        int consecutive_b_count = 0;
        int consecutive_c_count = 0;

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < maxSize; i++) {
            if (shouldAppendA(A, B, C, consecutive_a_count, consecutive_b_count, consecutive_c_count)) {
                output.append('a');

                A--;

                consecutive_a_count++;
                consecutive_b_count = 0;
                consecutive_c_count = 0;
            } else if (shouldAppendB(A, B, C, consecutive_a_count, consecutive_b_count, consecutive_c_count)) {
                output.append('b');

                B--;

                consecutive_b_count++;
                consecutive_c_count = 0;
                consecutive_a_count = 0;
            } else if (shouldAppendC(A, B, C, consecutive_a_count, consecutive_b_count, consecutive_c_count)) {
                output.append('c');

                C--;

                consecutive_c_count++;
                consecutive_a_count = 0;
                consecutive_b_count = 0;
            }
        }


        return output.toString();
    }

    private boolean shouldAppendA(int A, int B, int C, int consecutive_a_count, int consecutive_b_count, int consecutive_c_count) {
        return (isAMax(A, B, C) && consecutive_a_count < 2) || (A > 0 && consecutive_b_count == 2) || (A > 0 && consecutive_c_count == 2);
    }

    private boolean shouldAppendB(int A, int B, int C, int consecutive_a_count, int consecutive_b_count, int consecutive_c_count) {
        return (isBMax(A, B, C) && consecutive_b_count < 2) || (B > 0 && consecutive_a_count == 2) || (B > 0 && consecutive_c_count == 2);
    }

    private boolean shouldAppendC(int A, int B, int C, int consecutive_a_count, int consecutive_b_count, int consecutive_c_count) {
        return (isCMax(A, B, C) && consecutive_c_count < 2) || (C > 0 && consecutive_a_count == 2) || (C > 0 && consecutive_b_count == 2);
    }

    private boolean isAMax(int A, int B, int C) {
        return A > 0 && A >= B && A >= C;
    }

    private boolean isBMax(int A, int B, int C) {
        return B > 0 && B >= A && B >= C;
    }

    private boolean isCMax(int A, int B, int C) {
        return C > 0 && C >= B && C >= A;
    }

    public static void main(String[] args) {
        DiverseString diverseString = new DiverseString();
        diverseString.solution(1, -1, 2);
    }
}
