package org.example.oct2024;

public class MaximumNumberofMovesinaGrid2684 {
    public int maxMoves(int[][] grid) {
        int[][] points = new int[grid.length][grid[0].length];
        for (int column = grid[0].length - 1; column >= 0; column--) {
            int nextLeftColumn = column - 1;
            if (nextLeftColumn == -1) {
                break;
            }
            for (int row = 0; row < grid.length; row++) {
                int currentValue = grid[row][column];
                for (int nextRow = Math.max(0, row - 1); nextRow <= Math.min(grid.length - 1, row + 1); nextRow++) {
                    if (currentValue > grid[nextRow][nextLeftColumn]) {
                        points[nextRow][nextLeftColumn] = Math.max(points[row][column] + 1, points[nextRow][nextLeftColumn]);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max, points[i][0]);
        }
        return max;
    }
}
