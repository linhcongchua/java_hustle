package org.example.nov2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefusetheBomb1652Test {
    @Test
    void test1() {
        DefusetheBomb1652 test = new DefusetheBomb1652();
        int[] decrypt = test.decrypt(new int[]{5, 7, 1, 4}, 3);
        assertArrayEquals(new int[]{12, 10, 16, 13}, decrypt);
    }

    @Test
    void test2() {
        DefusetheBomb1652 test = new DefusetheBomb1652();
        int[] decrypt = test.decrypt(new int[]{2,4,9,3}, -2);
        assertArrayEquals(new int[]{12,5,6,13}, decrypt);
    }
}