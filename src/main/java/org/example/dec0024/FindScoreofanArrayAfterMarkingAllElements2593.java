package org.example.dec0024;

import java.util.ArrayList;
import java.util.List;

public class FindScoreofanArrayAfterMarkingAllElements2593 {
    public long findScore(int[] nums) {
        long score = 0l;
        List<Number> numbers = new ArrayList<Number>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numbers.add(new Number(nums[i], i));
        }

        numbers.sort((o1, o2) -> {
            if (o1.getNum() == o2.getNum()) {
                return o1.getIndex() - o2.getIndex();
            }
            return o1.getNum() - o2.getNum();
        });
        boolean[] visited = new boolean[numbers.size()];


        for (int i = 0; i < numbers.size(); i++) {
            Number number = numbers.get(i);
            if (visited[number.index]) {
                continue;
            }

            score += number.getNum();
            visited[number.getIndex()] = true;
            visited[Math.min(number.getIndex() + 1, numbers.size() - 1)] = true;
            visited[Math.max(number.getIndex() - 1, 0)] = true;
        }

        return score;
    }

    class Number {
        private int num;
        private int index;
        public Number(int num, int index) {
            this.num = num;
            this.index = index;
        }
        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "num=" + num +
                    ", index=" + index +
                    '}';
        }
    }
}
