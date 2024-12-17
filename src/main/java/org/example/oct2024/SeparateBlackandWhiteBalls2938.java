package org.example.oct2024;

public class SeparateBlackandWhiteBalls2938 {
    public long minimumSteps(String s) {
        char[] charArray = s.toCharArray();

        long stepCount = 0;
        int rightPointer = charArray.length - 1;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == '1') {
                stepCount += rightPointer - i;
                rightPointer--;
            }
        }
        return stepCount;
    }
}
