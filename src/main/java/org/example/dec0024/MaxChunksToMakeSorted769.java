package org.example.dec0024;

public class MaxChunksToMakeSorted769 {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            max = Math.max(max, num);
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}
