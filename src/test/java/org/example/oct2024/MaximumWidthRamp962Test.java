package org.example.oct2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumWidthRamp962Test {

    @Test
    void test1() {
        MaximumWidthRamp962 mw = new MaximumWidthRamp962();
        assertEquals(4, mw.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
    }

    @Test
    void test2() {
        MaximumWidthRamp962 mw = new MaximumWidthRamp962();
        assertEquals(7, mw.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }
}