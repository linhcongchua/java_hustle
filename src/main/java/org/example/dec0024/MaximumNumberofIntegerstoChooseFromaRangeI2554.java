package org.example.dec0024;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberofIntegerstoChooseFromaRangeI2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<Integer>();
        for (int i = 0; i < banned.length; i++) {
            bannedSet.add(banned[i]);
        }
        int currentSum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (currentSum + i > maxSum) {
                break;
            }
            if(bannedSet.contains(i)) {
                continue;
            }
            currentSum += i;
            count++;
        }
        return count;
    }
}
