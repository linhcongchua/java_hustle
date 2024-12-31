package org.example.dec0024;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _4Sum18Test {

    @Test
    void test1() {
        _4Sum18 test = new _4Sum18();
        List<List<Integer>> lists = test.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
    }

    @Test
    void test2() {
        _4Sum18 test = new _4Sum18();
        List<List<Integer>> lists = test.fourSum(new int[]{-1000000000,-1000000000,1000000000,-1000000000,-1000000000}, 294967296);
        System.out.println(lists);
    }
}