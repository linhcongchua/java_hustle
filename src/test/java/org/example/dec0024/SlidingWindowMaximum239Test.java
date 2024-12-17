package org.example.dec0024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowMaximum239Test {
    @Test
    void test() {
        SlidingWindowMaximum239 test = new SlidingWindowMaximum239();
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

}