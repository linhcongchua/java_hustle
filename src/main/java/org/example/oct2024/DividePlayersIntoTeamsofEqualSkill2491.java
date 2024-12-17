package org.example.oct2024;

import java.util.Arrays;

public class DividePlayersIntoTeamsofEqualSkill2491 {
    public long dividePlayers(int[] skill) {
        long chemistry = 0;
        Arrays.sort(skill);
        int left = 0;
        int right = skill.length - 1;
        int lastSumSkill = -1;
        while (left < right) {
            int currentSum = skill[left] + skill[right];
            if (lastSumSkill == -1) {
                lastSumSkill = currentSum;
                chemistry+=((long) skill[left] * skill[right]);
                left++;
                right--;
                continue;
            }
            if (currentSum != lastSumSkill) {
                return -1;
            }
            chemistry+=((long) skill[left] * skill[right]);
            left++;
            right--;
        }
        return chemistry;
    }
}
