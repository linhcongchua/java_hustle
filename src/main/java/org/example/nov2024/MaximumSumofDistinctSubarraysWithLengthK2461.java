package org.example.nov2024;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumofDistinctSubarraysWithLengthK2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long sliceSum = 0;
        Map<Integer, Integer> appear = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sliceSum += nums[i];
            int prev = appear.getOrDefault(nums[i], 0);
            prev++;
            appear.put(nums[i], prev);
        }
        if (appear.size() == k) {
            maxSum = Math.max(maxSum, sliceSum);
        }

        for (int i = k; i < nums.length; i++) {
            sliceSum += nums[i];
            sliceSum -= nums[i - k];
            appear.put(nums[i], appear.getOrDefault(nums[i], 0) + 1);
            int removeAppear = appear.get(nums[i - k]);
            removeAppear--;
            if (removeAppear == 0) {
                appear.remove(nums[i - k]);
            } else {
                appear.put(nums[i - k], removeAppear);
            }
            if (appear.size() == k) {
                maxSum = Math.max(maxSum, sliceSum);
            }
        }
        return maxSum;
    }
}
