package org.example.dec0024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            int first = nums[i];
            if (i > 0 && first == nums[i - 1]) {
                continue; // skip last one
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                int second = nums[j];
                if (j > i + 1 && second == nums[j - 1]) {
                    continue; // skip last one
                }

                for (int k = j + 1; k < nums.length - 1; k++) {
                    int third = nums[k];
                    if (k > j + 1 && third == nums[k - 1]) {
                        continue; // skip last one
                    }

                    long need = (long) target - first - second - third;
                    if (find(nums, need, k + 1)) {
                        res.add(Arrays.asList(first, second, third, (int) need));
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{-2, -1, 0, 0, 1, 2}, 2, 4));
    }

    private static boolean find(int[] nums, long findOne, int startIndex) {
        int left = startIndex;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < findOne) {
                left = middle + 1;
            } else if (nums[middle] > findOne) {
                right = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
