package org.example.nov2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounttheNumberofFairPairs2563Test {
    @Test
    void test() {
        CounttheNumberofFairPairs2563 test = new
                CounttheNumberofFairPairs2563();
        long count = test.countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6);
        assertEquals(6, count);
    }
}