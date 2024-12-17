package org.example.oct2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberofSwapstoMaketheStringBalanced1963Test {

    @Test
    void test1() {
        MinimumNumberofSwapstoMaketheStringBalanced1963 test = new MinimumNumberofSwapstoMaketheStringBalanced1963();
        assertEquals(1, test.minSwaps("][][]["));
    }

    @Test
    void test2() {
        MinimumNumberofSwapstoMaketheStringBalanced1963 test = new MinimumNumberofSwapstoMaketheStringBalanced1963();
        assertEquals(1, test.minSwaps("][]["));
    }
}