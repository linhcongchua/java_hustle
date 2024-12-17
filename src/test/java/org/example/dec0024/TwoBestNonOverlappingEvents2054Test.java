package org.example.dec0024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoBestNonOverlappingEvents2054Test {
    @Test
    void test1() {
        TwoBestNonOverlappingEvents2054 test = new TwoBestNonOverlappingEvents2054();
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        assertEquals(4, test.maxTwoEvents(events));
    }

    @Test
    void test2() {
        TwoBestNonOverlappingEvents2054 test = new TwoBestNonOverlappingEvents2054();
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        assertEquals(5, test.maxTwoEvents(events));
    }
}