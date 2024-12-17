package org.example.oct2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestHappyString1405Test {
    @Test
    void testLongestHappyString() {
        LongestHappyString1405 test = new LongestHappyString1405();
        assertEquals("ccaccbcc", test.longestDiverseString(1, 1, 7));
    }
}