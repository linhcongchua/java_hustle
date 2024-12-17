package org.example.nov2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MostBeautifulItemforEachQuery2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Integer[] sortedIndexes = new Integer[items.length];
        for (int i = 0; i < items.length; i++) {
            sortedIndexes[i] = i;
        }
        Arrays.sort(sortedIndexes, Comparator.comparingInt(index -> items[index][0]));

        int max = 0;
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        for (int i = 0; i < sortedIndexes.length; i++) {
            int index = sortedIndexes[i];
            max = Math.max(max, items[index][1]);
            sortedMap.put(items[index][0], max);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var closetMax = sortedMap.floorEntry(queries[i]);
            result[i] = closetMax == null ? 0 : closetMax.getValue();
        }
        return result;
    }
}
