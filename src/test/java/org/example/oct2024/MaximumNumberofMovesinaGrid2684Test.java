package org.example.oct2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberofMovesinaGrid2684Test {
    @Test
    void test1() {
        int[][] myArray = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };
        MaximumNumberofMovesinaGrid2684 test = new MaximumNumberofMovesinaGrid2684();
        assertEquals(3, test.maxMoves(myArray));
    }
}