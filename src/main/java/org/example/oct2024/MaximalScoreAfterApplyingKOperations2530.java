package org.example.oct2024;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }

        long sum = 0;
        for (int i = 0; i < k; i++) {
            Integer poll = pq.poll();
            if (poll == 0) {
                break;
            }
            sum += poll;
            boolean isDivide = (poll % 3) == 0;
            int left = poll / 3 + (isDivide ? 0 : 1);
            pq.add(left);
        }
        return sum;
    }
}
