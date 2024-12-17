package org.example.nov2024;

public class DefusetheBomb1652 {
    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        if (k == 0) {
            return new int[code.length];
        }
        int[] result = new int[code.length];

        int direction = k > 0 ? 1 : -1;
        int preSum = 0;
        for (int i = 0; direction > 0 ? i < k : length - i < length - k; i += direction) {
            preSum += code[(length + i) % length];
        }

        preSum -= code[0];
        preSum += code[(k + length) % code.length];
        result[0] = preSum;
        for (int i = 1; i < code.length; i++) {
            if (k > 0) {
                preSum -= code[i];
                preSum += code[(i + k + length) % code.length];
            } else {
                preSum -= code[(i + k + length - 1) % length];
                preSum += code[(i + length - 1) % code.length];
            }
            result[i] = preSum;
        }
        return result;
    }
    // 2,4,9,3 | k = -2
    // 12,5,6,13
}
