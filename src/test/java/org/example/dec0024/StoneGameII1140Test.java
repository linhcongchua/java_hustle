package org.example.dec0024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoneGameII1140Test {

    @Test
    void test1() {
        StoneGameII1140 test = new StoneGameII1140();
        assertEquals(10, test.stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }
}