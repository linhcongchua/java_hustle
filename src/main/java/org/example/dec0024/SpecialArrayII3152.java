package org.example.dec0024;

import java.util.TreeMap;

public class SpecialArrayII3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        // start-end
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int start = 0;
        int end = 0;
        int lastRemain = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            int remain = nums[i] % 2;
            if (lastRemain == remain) {
                map.put(start, end);
                start = i;
                end = i;
            } else {
                end = i;
            }
            lastRemain = remain;
        }
        map.put(start, end);

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // check start
            var rangeSpecial = map.floorEntry(queries[i][0]);
            // check end
            var anotherRangeSpecial = map.floorEntry(queries[i][1]);

            result[i] = rangeSpecial.equals(anotherRangeSpecial);
        }

        return result;
    }

    static class Prefix {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            boolean[][] matrix = new boolean[nums.length][nums.length];
            for (int i = 0; i < nums.length - 1; i++) {
                boolean status = true;
                int lastRemain = nums[i] % 2;
                for (int j = i + 1; j < nums.length; j++) {
                    if (!status) {
                        matrix[i][j] = true;
                        continue;
                    }
                    int remain = nums[j] % 2;
                    if (lastRemain == remain) {
                        matrix[i][j] = true;
                        status = false;
                    }
                    lastRemain = remain;
                }
            }

            boolean[] result = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                var query = queries[i];
                result[i] = !matrix[query[0]][query[1]];
            }
            return result;
        }
    }
}
