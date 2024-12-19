package org.example.dec0024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxChunksToMakeSorted769Test {

    @Test
    void test1() {
        MaxChunksToMakeSorted769 test = new MaxChunksToMakeSorted769();
        assertEquals(1, test.maxChunksToSorted(new int[]{1, 4, 3, 6, 0, 7, 8, 2, 5}));
    }

    @Test
    void test2() {
        MaxChunksToMakeSorted769 test = new MaxChunksToMakeSorted769();
        assertEquals(1, test.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
    }

    @Test
    void test3() {
        MaxChunksToMakeSorted769 test = new MaxChunksToMakeSorted769();
        assertEquals(4, test.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }
}