package org.example.nov2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestSubarraytobeRemovedtoMakeArraySorted1574Test {
    @Test
    void test1() {
        ShortestSubarraytobeRemovedtoMakeArraySorted1574 test = new ShortestSubarraytobeRemovedtoMakeArraySorted1574();
        assertEquals(3, test.findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
    }

    @Test
    void test2() {
        ShortestSubarraytobeRemovedtoMakeArraySorted1574 test = new ShortestSubarraytobeRemovedtoMakeArraySorted1574();
        assertEquals(4, test.findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void test3() {
        ShortestSubarraytobeRemovedtoMakeArraySorted1574 test = new ShortestSubarraytobeRemovedtoMakeArraySorted1574();
        assertEquals(8, test.findLengthOfShortestSubarray(new int[]{13, 0, 14, 7, 18, 18, 18, 16, 8, 15, 20}));
    }

}