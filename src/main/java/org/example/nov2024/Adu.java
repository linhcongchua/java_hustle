package org.example.nov2024;

import java.util.Comparator;
import java.util.List;

public class Adu {
//    [9,11,99,101]
//    [[10,1],[7,1],[14,1],[100,1],[96,1],[103,1]]
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(Comparator.comparingInt(o -> o));

        return 1l;
    }

    class Factory {
        private int position;
        private int capacity;

        public Factory(int position, int capacity) {
            this.position = position;
            this.capacity = capacity;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
    }
}
