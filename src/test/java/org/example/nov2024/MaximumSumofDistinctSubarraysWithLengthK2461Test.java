package org.example.nov2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSumofDistinctSubarraysWithLengthK2461Test {
    // 1,5,4,2,9,9,9
    @Test
    void test1() {
        MaximumSumofDistinctSubarraysWithLengthK2461 test = new MaximumSumofDistinctSubarraysWithLengthK2461();
        assertEquals(15, test.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    }
}