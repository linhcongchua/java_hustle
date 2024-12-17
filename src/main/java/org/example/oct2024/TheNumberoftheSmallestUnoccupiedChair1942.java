package org.example.oct2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheNumberoftheSmallestUnoccupiedChair1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        List<GuestComing> guests = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            guests.add(new GuestComing(times[i][0], times[i][1], i));
        }
        guests.sort(Comparator.comparingInt(GuestComing::getArrival));

        int volumeChair = 0;
        PriorityQueue<Integer> availableOccupied = new PriorityQueue<>();
        PriorityQueue<GuestLeaving> guestLeavings =
                new PriorityQueue<>(Comparator.comparingInt(GuestLeaving::getLeaving));

        for (GuestComing guest : guests) {

            // check guest leave
            int arrival = guest.getArrival();
            while (!guestLeavings.isEmpty() && guestLeavings.peek().getLeaving() <= arrival) {
                GuestLeaving guestLeaving = guestLeavings.poll();
                availableOccupied.add(guestLeaving.getChairNum());
            }

            if (availableOccupied.isEmpty()) {
                availableOccupied.add(volumeChair);
                volumeChair++;
            }

            Integer poll = availableOccupied.poll();
            if (guest.getSeq() == targetFriend) {
                return poll;
            }
            guestLeavings.add(new GuestLeaving(guest.leaving, poll));
        }
        return -1;
    }

    private static class GuestLeaving {
        int leaving;
        int chairNum;

        public GuestLeaving(int leaving, int chairNum) {
            this.leaving = leaving;
            this.chairNum = chairNum;
        }

        public int getLeaving() {
            return leaving;
        }

        public int getChairNum() {
            return chairNum;
        }
    }

    private static class GuestComing {
        int arrival;
        int leaving;
        int seq;

        public GuestComing(int arrival, int leaving, int seq) {
            this.arrival = arrival;
            this.leaving = leaving;
            this.seq = seq;
        }

        public int getArrival() {
            return arrival;
        }

        public int getLeaving() {
            return leaving;
        }

        public int getSeq() {
            return seq;
        }
    }
}
