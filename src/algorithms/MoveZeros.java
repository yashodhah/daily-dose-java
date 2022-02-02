package algorithms;

public class MoveZeros {
    public static void moveZeroes(int[] items) {
        int i = items.length - 1;
        int lastZeroIdx = items.length - 1;

        while (i >= 0) {
            if (items[i] == 0) {
                int j = i;

                while (j < lastZeroIdx) {
                    items[j] = items[j + 1];
                    j++;
                }

                items[lastZeroIdx] = 0;
                lastZeroIdx--;
            }

            i--;
        }
    }

    public static void smartMoveZeroes(int[] items) {
        int insertIdx = 0;

        for (int num : items) {
            if (num != 0) {
                items[insertIdx] = num;
                insertIdx++;
            }
        }

        while (items.length > insertIdx) {
            items[insertIdx] = 0;
            insertIdx++;
        }
    }
}
