package leet_code;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int out = 0;
        int consecutiveZeros = 1;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (consecutiveZeros >= 3) {
                    out += calculate(consecutiveZeros);
                }
                consecutiveZeros = 0;
            } else {
                consecutiveZeros++;
            }
        }

        consecutiveZeros++;
        if (consecutiveZeros >= 3) {
            out += calculate(consecutiveZeros);
        }

        return out >= n;
    }

    private int calculate(int adjEmptySpaces) {
        if (adjEmptySpaces % 2 == 0) {
            adjEmptySpaces = adjEmptySpaces - 1;
        }

        return adjEmptySpaces / 2;
    }

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }
}
