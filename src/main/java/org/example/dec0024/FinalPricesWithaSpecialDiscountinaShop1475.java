package org.example.dec0024;

import java.util.Stack;

public class FinalPricesWithaSpecialDiscountinaShop1475 {

    public int[] finalPrices(int[] prices) {
        Stack<Price> stack = new Stack<>();
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty()) {
                stack.add(new Price(prices[i], i));
                continue;
            }

            while (!stack.isEmpty() && prices[i] <= stack.peek().value) {
                Price pop = stack.pop();
                result[pop.index] = pop.value - prices[i];
            }
            stack.add(new Price(prices[i], i));
        }
        while (!stack.isEmpty()) {
            Price pop = stack.pop();
            result[pop.index] = pop.value;
        }

        return result;
    }
    static class Price {
        int value;
        int index;

        public Price(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
