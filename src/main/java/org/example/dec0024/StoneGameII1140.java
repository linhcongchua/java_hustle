package org.example.dec0024;

public class StoneGameII1140 {

    public int stoneGameII(int[] piles) {
        return max(piles, 0, 1);
    }

    public int max(int[] piles, int startIndex, int max, boolean flag) {
        int gain = 0;

        int possibleTake = max * 2;
        for (int i = 1; i <= possibleTake; i++) {
            int endIndex = startIndex + i;
            if (endIndex >= piles.length) {
                return gain;
            }


            gain = Math.max(gain,sum(piles, startIndex, endIndex) + max(piles, endIndex, Math.max(max, i)));
        }

        return gain;
    }

    int sum(int[] piles, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += piles[i];
        }
        return sum;
    }
}
