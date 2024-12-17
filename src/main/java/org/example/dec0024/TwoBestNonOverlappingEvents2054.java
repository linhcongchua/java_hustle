package org.example.dec0024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TwoBestNonOverlappingEvents2054 {

    final int START_INDEX = 0;
    final int END_INDEX = 1;
    final int VALUE_INDEX = 2;

    public int maxTwoEvents(int[][] events) {

        if (events.length == 1) {
            return events[0][VALUE_INDEX];
        }

        List<Event> sortedByStart = new ArrayList<Event>();
        List<Event> sortedByEnd = new ArrayList<Event>();
        for (int i = 0; i < events.length; i++) {
            sortedByStart.add(new Event(
                    events[i][START_INDEX],
                    events[i][END_INDEX],
                    events[i][VALUE_INDEX])
            );
            sortedByEnd.add(new Event(
                    events[i][START_INDEX],
                    events[i][END_INDEX],
                    events[i][VALUE_INDEX])
            );
        }
        sortedByStart.sort(Comparator.comparingInt(Event::getStart));
        sortedByEnd.sort(Comparator.comparingInt(Event::getEnd));
        Integer currentMax = null;
        int indexEnd = -1;
        int max = 0;
        for (int i = 0; i < sortedByStart.size(); i++) {
            Event event = sortedByStart.get(i);
            int start = event.getStart();
            max = Math.max(max, event.getValue());

            while (indexEnd + 1 < sortedByEnd.size() && start > sortedByEnd.get(indexEnd + 1).getEnd()) {
                indexEnd++;
                if (currentMax == null) {
                    currentMax = sortedByEnd.get(indexEnd).getValue();
                    continue;
                }
                currentMax = Math.max(currentMax, sortedByEnd.get(indexEnd).getValue());
            }
            if (currentMax != null) {
                max = Math.max(max, event.getValue() + currentMax);
            }
        }

        return max;
    }

    static class Event {
        private int start;
        private int end;
        private int value;

        public Event(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "start=" + start +
                    ", end=" + end +
                    ", value=" + value +
                    '}';
        }
    }
}
