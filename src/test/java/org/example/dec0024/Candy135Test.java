package org.example.dec0024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Candy135Test {

    @Test
    void test1() {
        Candy135 test = new Candy135();
        assertEquals(5, test.candy(new int[]{1, 0, 2}));
    }
}