package org.example.dec0024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberofIntegerstoChooseFromaRangeI2554Test {

    @Test
    void test() {
        MaximumNumberofIntegerstoChooseFromaRangeI2554 test = new MaximumNumberofIntegerstoChooseFromaRangeI2554();
        assertEquals(2, test.maxCount(new int[]{1, 6, 5}, 5, 6));
    }

    @Test
    void test2() {
        MaximumNumberofIntegerstoChooseFromaRangeI2554 test = new MaximumNumberofIntegerstoChooseFromaRangeI2554();
        assertEquals(7, test.maxCount(new int[]{11}, 7, 50));
    }
}