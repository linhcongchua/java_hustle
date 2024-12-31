package org.example.dec0024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Candy135 {
    /*
    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    Return the minimum number of candies you need to have to distribute the candies to the children.
     */
    public int candy(int[] ratings) {
        int[] levels = new int[ratings.length];
        List<Candy> candies = new ArrayList<>(ratings.length);
        for (int i = 0; i < ratings.length; i++) {
            levels[i] = 1;
            candies.add(new Candy(i, ratings[i]));
        }
        candies.sort(Comparator.comparingInt(Candy::getRating));

        for (int i = 0; i < candies.size(); i++) {
            Candy candy = candies.get(i);

            int index = candy.getIndex();
            int rating = candy.getRating();

            int left = index - 1;
            int right = index + 1;
            if (left >= 0 && rating < ratings[left]) {
                levels[left] = Math.max(levels[left], levels[index] + 1);
            }
            if (right < ratings.length && rating < ratings[right]) {
                levels[right] = Math.max(levels[right], levels[index] + 1);
            }
        }
        return Arrays.stream(levels).sum();
    }

    static class Candy {
        private int index;
        private int rating;

        public Candy(int index, int rating) {
            this.index = index;
            this.rating = rating;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Candy{" +
                    "index=" + index +
                    ", rating=" + rating +
                    '}';
        }
    }
}
