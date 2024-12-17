package org.example.nov2024;

public class ShortestSubarraytobeRemovedtoMakeArraySorted1574 {
    // 1,2,3,10,4,2,3,5 -> 10,4,2
    public int findLengthOfShortestSubarray(int[] arr) {
        int[] value = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            value[i] = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] >= arr[j]) {
                    value[i] = Math.min(value[i], value[j] + (i - j - 1));
                }
            }
        }
        return 0;
    }
}
