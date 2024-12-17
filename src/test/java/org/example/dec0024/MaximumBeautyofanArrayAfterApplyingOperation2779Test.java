package org.example.dec0024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumBeautyofanArrayAfterApplyingOperation2779Test {
    @Test
    void test1() { // test binary
        int[] nums = {1, 2, 3, 5, 5, 5, 7, 9};
        int target = 6;

        MaximumBeautyofanArrayAfterApplyingOperation2779.Another test = new MaximumBeautyofanArrayAfterApplyingOperation2779.Another();
        int maxIndex = test.findMaxIndex(nums, target);

        assertEquals(5, maxIndex);
    }

    @Test
    void test2() { // test binary
        int[] nums = {1, 2, 3, 5, 6, 7, 7, 7, 9};
        int target = 6;

        MaximumBeautyofanArrayAfterApplyingOperation2779.Another test = new MaximumBeautyofanArrayAfterApplyingOperation2779.Another();
        int maxIndex = test.findMinIndex(nums, target);

        assertEquals(4, maxIndex);
    }
}