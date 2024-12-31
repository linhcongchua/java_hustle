package org.example.dec0024;

import java.util.Arrays;

public class MaximumGap164 {
    // 3,6,9,1
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }
}
