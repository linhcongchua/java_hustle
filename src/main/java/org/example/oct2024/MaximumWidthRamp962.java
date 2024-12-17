package org.example.oct2024;

import java.util.Stack;
import java.util.TreeMap;

public class MaximumWidthRamp962 {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> monoStack = new Stack<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {

            if (!monoStack.isEmpty()) {
                var floorEntry = map.floorEntry(nums[i]);
                if (floorEntry != null) {
                    max = Math.max(max, i - map.floorEntry(nums[i]).getValue());
                }
            }


            if (monoStack.empty()) {
                monoStack.push(nums[i]);
                map.put(nums[i], i);
            } else if (monoStack.peek() > nums[i]) {
                monoStack.push(nums[i]);
                map.put(nums[i], i);
            }
        }
        return max;
    }
}
