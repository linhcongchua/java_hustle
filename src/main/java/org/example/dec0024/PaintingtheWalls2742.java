package org.example.dec0024;

import java.util.HashMap;
import java.util.Map;

public abstract class PaintingtheWalls2742 {

    abstract int paintWalls(int[] cost, int[] time);

    static class TopDown extends PaintingtheWalls2742 {
        // Find max cost the free painter can gain!
        // number of free paint <= totalTime - (sum of free paint's time)
        @Override
        public int paintWalls(int[] cost, int[] time) {
            Map<Key, Integer> cache = new HashMap<Key, Integer>();
            return doPaint(0, 0, cost, time, cache);
        }

        private int doPaint(int index, int currentTime, int[] cost, int[] time, Map<Key, Integer> cache) {
            if (cache.containsKey(new Key(index, currentTime))) {
                return cache.get(new Key(index, currentTime));
            }
            if (index == cost.length) {
                return currentTime >= 0 ? 0 : 100_000;
            }

            int paint = cost[index] + doPaint(index + 1, currentTime + time[index], cost, time, cache);
            int dontPaint = doPaint(index + 1, currentTime - 1, cost, time, cache);
            int min = Math.min(paint, dontPaint);
            cache.put(new Key(index, currentTime), min);
            return min;
        }

        record Key(int index, int currentTime) {}
    }

    static class BottomUp extends PaintingtheWalls2742 {

        @Override
        int paintWalls(int[] cost, int[] time) {
            return 0;
        }
    }
}
