package org.example.dec0024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaintingtheWalls2742Test {
    @Test
    void test1() {
        PaintingtheWalls2742 test = new PaintingtheWalls2742.TopDown();
        assertEquals(55, test.paintWalls(new int[]{26, 53, 10, 24, 25, 20, 63, 51}, new int[]{1, 1, 1, 1, 2, 2, 2, 1}));
    }

    @Test
    void test2() {
        PaintingtheWalls2742 test = new PaintingtheWalls2742.TopDown();
        assertEquals(76, test.paintWalls(new int[]{7,15,38,35,61,90,34,29,68,35}, new int[]{1,1,3,3,2,1,3,1,2,3}));
    }
}