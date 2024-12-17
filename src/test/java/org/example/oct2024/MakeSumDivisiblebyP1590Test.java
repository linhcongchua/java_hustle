package org.example.oct2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeSumDivisiblebyP1590Test {

    @Test
    void test1() {
        MakeSumDivisiblebyP1590 test = new MakeSumDivisiblebyP1590();
        assertEquals(2, test.minSubarray(new int[]{6, 3, 5, 2}, 9));
    }

    @Test
    void test2() {
        MakeSumDivisiblebyP1590 test = new MakeSumDivisiblebyP1590();
        assertEquals(1, test.minSubarray(new int[]{3, 1, 4, 2}, 6));
    }

    @Test
    void test3() {
        MakeSumDivisiblebyP1590 test = new MakeSumDivisiblebyP1590();
        assertEquals(0, test.minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3));
    }

    @Test
    void test4() {
        MakeSumDivisiblebyP1590 test = new MakeSumDivisiblebyP1590();
        assertEquals(7, test.minSubarray(new int[]{8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2}, 148));
    }
}