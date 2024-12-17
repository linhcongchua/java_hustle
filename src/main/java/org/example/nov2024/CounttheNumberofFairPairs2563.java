package org.example.nov2024;

import java.util.Arrays;
import java.util.TreeMap;

public class CounttheNumberofFairPairs2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);
        // sorted
        TreeMap<Integer, Integer> sortedMapMin = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (sortedMapMin.containsKey(nums[i])) {
                continue;
            }
            sortedMapMin.put(nums[i], i);
        }
        TreeMap<Integer, Integer> sortedMapMax = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            sortedMapMax.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int expectedMin = lower - nums[i];
            int expectedMax = upper - nums[i];

            var ceilMin = sortedMapMin.ceilingEntry(expectedMin);
            var floorMax = sortedMapMax.floorEntry(expectedMax);

            if (ceilMin != null && floorMax != null && ceilMin.getValue() <= floorMax.getValue()) {
                count += floorMax.getValue() - ceilMin.getValue() + 1;
                if (ceilMin.getValue() <= i && i <= floorMax.getValue()) {
                    count--;
                }
            }
        }
        return count/2;
    }
}
