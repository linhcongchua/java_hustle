package org.example.nov2024;

public class MaximumMatrixSum1975 {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        long min = Integer.MAX_VALUE;
        boolean isEven = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int abs = Math.abs(matrix[i][j]);
                sum += abs;
                min = Math.min(min, abs);
                if (matrix[i][j] < 0) {
                    isEven = !isEven;
                }
            }
        }
        if (isEven) {
            return sum;
        }
        return sum - min * 2;
    }
}
