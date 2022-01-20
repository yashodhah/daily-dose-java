package sort;

public class InsertionSort {
    public static void sort(int[] items) {
        for (int i = 1; i < items.length; i++) {
            int num = items[i];
            int j = i - 1;

            while (j >= 0 && items[j] > num) {
                items[j + 1] = items[j];
                j--;
            }

            items[j + 1] = num;
        }
    }
}
