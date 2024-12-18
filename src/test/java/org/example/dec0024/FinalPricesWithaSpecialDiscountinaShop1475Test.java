package org.example.dec0024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinalPricesWithaSpecialDiscountinaShop1475Test {

    @Test
    void test1() {
        FinalPricesWithaSpecialDiscountinaShop1475 test = new FinalPricesWithaSpecialDiscountinaShop1475();
        assertArrayEquals(new int[]{4, 2, 4, 2, 3}, test.finalPrices(new int[]{8, 4, 6, 2, 3}));
    }
}