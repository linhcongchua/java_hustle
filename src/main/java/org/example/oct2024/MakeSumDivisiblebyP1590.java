package org.example.oct2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisiblebyP1590 {
    public int minSubarray(int[] nums, int p) {
        long total = Arrays.stream(nums).asLongStream().sum();
        long remainderSub = total % p;
        if (remainderSub == 0) {
            return 0;
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, -1); // To handle the case where the whole prefix is the answer
        int length = nums.length;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long remainder = sum % p;
            long key = remainder - remainderSub;
            if (key < 0) {
                key += p;
            }
            Integer expect = map.get(key);
            if (expect != null) {
                length = Math.min(length, i - expect);
            }
            map.put(remainder, i);
        }

        return length == nums.length ? -1 : length;
    }

    public int minSubarray1(int[] nums, int p) {
        int n = nums.length;
        int totalSum = 0;

        // Step 1: Calculate total sum and target remainder
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }

        int target = totalSum % p;
        if (target == 0) {
            return 0; // The array is already divisible by p
        }

        // Step 2: Use a hash map to track prefix sum mod p
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); // To handle the case where the whole prefix is the answer
        int currentSum = 0;
        int minLen = n;

        // Step 3: Iterate over the array
        for (int i = 0; i < n; ++i) {
            currentSum = (currentSum + nums[i]) % p;

            // Calculate what we need to remove
            int needed = (currentSum - target + p) % p;

            // If we have seen the needed remainder, we can consider this subarray
            if (modMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }

            // Store the current remainder and index
            modMap.put(currentSum, i);
        }

        // Step 4: Return result
        return minLen == n ? -1 : minLen;
    }
}
