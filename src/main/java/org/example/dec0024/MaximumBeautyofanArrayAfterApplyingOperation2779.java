package org.example.dec0024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumBeautyofanArrayAfterApplyingOperation2779 {

    static class Another {
        public int maximumBeauty(int[] nums, int k) {
            Arrays.sort(nums);

            int max = 0;

            int maxNum = Arrays.stream(nums).max().getAsInt();
            int minNum = Arrays.stream(nums).min().getAsInt();
            for (int targetNum = minNum; targetNum <= maxNum; targetNum++) {
                int leftIndex = findMinIndex(nums, targetNum - k);
                int rightIndex = findMaxIndex(nums, targetNum + k);
                max = Math.max(max, rightIndex - leftIndex + 1);
            }
            return max;
        }

        public static int findMaxIndex(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int maxIndex = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] <= target) {
                    maxIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return maxIndex;
        }

        public static int findMinIndex(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int minIndex = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] >= target) {
                    minIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return minIndex;
        }
    }

    class BruteForce {
        // binary ???
        public int maximumBeauty(int[] nums, int k) {
            int maxContinue = 0;
            int max = Arrays.stream(nums).max().getAsInt();
            int min = Arrays.stream(nums).min().getAsInt();
            for (int line = min; line <= max; line++) {
                int current = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] - k <= line && line <= nums[i] + k) {
                        current++;
                    }
                    maxContinue = Math.max(maxContinue, current);
                }
            }
            return maxContinue;
        }
    }

    class AnotherBruteForce {
        public int maximumBeauty(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = nums[i] - k; j < nums[i] + k; j++) {
                    Integer appear = map.getOrDefault(j, 0);
                    map.put(j, appear + 1);
                }
            }
            return map.values().stream().max(Integer::compareTo).get();
        }
    }
}
