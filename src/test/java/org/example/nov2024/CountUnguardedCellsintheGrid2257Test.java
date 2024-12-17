package org.example.nov2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountUnguardedCellsintheGrid2257Test {
    @Test
    void test1() {
        CountUnguardedCellsintheGrid2257 test = new CountUnguardedCellsintheGrid2257();
        int[][] guards = new int[3][2];
        guards[0] = new int[]{0, 0};
        guards[1] = new int[]{1, 1}; //[[0,1],[2,2],[1,4]]
        guards[2] = new int[]{2, 3};

        int[][] walls = new int[3][2];
        walls[0] = new int[]{0, 1};
        walls[1] = new int[]{2, 2}; //[[0,1],[2,2],[1,4]]
        walls[2] = new int[]{1, 4};

        assertEquals(7, test.countUnguarded(4, 6, guards, walls));
    }

}