package org.example.dec0024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialArrayII3152Test {
    @Test
    void test1() {
//        SpecialArrayII3152 test = new SpecialArrayII3152();
        SpecialArrayII3152.Prefix test = new SpecialArrayII3152.Prefix();
        int[][] queries = {{0, 2}, {2, 3}};
        assertArrayEquals(new boolean[]{false, true}, test.isArraySpecial(new int[]{4, 3, 1, 6}, queries));
    }

    @Test
    void test2() {
        //        SpecialArrayII3152 test = new SpecialArrayII3152();
        SpecialArrayII3152.Prefix test = new SpecialArrayII3152.Prefix();
        int[][] queries = {{2, 3}};
        assertArrayEquals(new boolean[]{true}, test.isArraySpecial(new int[]{10, 2, 10, 9, 7}, queries));
    }

    @Test
    void test3() {
        //        SpecialArrayII3152 test = new SpecialArrayII3152();
        SpecialArrayII3152.Prefix test = new SpecialArrayII3152.Prefix();
        int[][] queries = {{0, 1}};
        assertArrayEquals(new boolean[]{true}, test.isArraySpecial(new int[]{1, 4}, queries));
    }

    @Test
    void test4() {
        //        SpecialArrayII3152 test = new SpecialArrayII3152();
        SpecialArrayII3152.Prefix test = new SpecialArrayII3152.Prefix();
        int[][] queries = {{1, 5}};
        assertArrayEquals(new boolean[]{false}, test.isArraySpecial(new int[]{4, 1, 2, 9, 9, 8, 8}, queries));
    }
}