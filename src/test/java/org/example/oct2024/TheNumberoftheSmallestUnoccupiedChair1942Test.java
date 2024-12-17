package org.example.oct2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheNumberoftheSmallestUnoccupiedChair1942Test {
    @Test
    void test1() {
        TheNumberoftheSmallestUnoccupiedChair1942 test =
                new TheNumberoftheSmallestUnoccupiedChair1942();

        int[][] times = new int[][]{{3,10}, {1,5}, {2,6}};
        assertEquals(2, test.smallestChair(times, 0));
    }
}