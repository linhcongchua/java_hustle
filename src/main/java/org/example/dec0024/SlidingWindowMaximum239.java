package org.example.dec0024;

import java.util.LinkedList;

public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length - 1; i++) {
            res[i] = queue.getFirst();

            // next one
            int next =  nums[i + k];
            while (!queue.isEmpty() && queue.getLast() < next) {
                queue.removeLast();
            }
            queue.addLast(next);

            int remove = nums[i];
            if (remove == queue.getFirst()) {
                queue.removeFirst();
            }
        }
        res[res.length - 1] = queue.getFirst();

        return res;
    }
}
