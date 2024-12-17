package org.example.oct2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestHappyString1405 {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<MyCharacter> queue = new PriorityQueue<>(Comparator.comparing(MyCharacter::getRemain).reversed());
        if (a > 0) {
            queue.add(new MyCharacter('a', a));
        }
        if (b > 0) {
            queue.add(new MyCharacter('b', b));
        }
        if (c > 0) {
            queue.add(new MyCharacter('c', c));
        }

        char[] characters = new char[a + b + c];
        Arrays.fill(characters, ' ');
        int count = 0;
        char lastCharacter = 'd';
        for (int i = 0; i < characters.length; i++) {
            if (queue.isEmpty()) {
                break;
            }
            MyCharacter poll = queue.poll();
            if (poll.character == lastCharacter) {
                if (count == 2) {
                    if (queue.isEmpty()) {
                        break;
                    }
                    MyCharacter anotherPoll = queue.poll();
                    count = 1;
                    queue.add(poll);
                    characters[i] = anotherPoll.character;
                    lastCharacter = anotherPoll.character;
                    anotherPoll.remain--;
                    if (anotherPoll.remain != 0) {
                        queue.add(anotherPoll);
                    }
                } else {
                    characters[i] = poll.character;
                    poll.remain--;
                    if (poll.remain != 0) {
                        queue.add(poll);
                    }
                    count++;
                }
            } else {
                count = 1;
                characters[i] = poll.character;
                lastCharacter = poll.character;
                poll.remain--;
                if (poll.remain != 0) {
                    queue.add(poll);
                }
            }
        }
        return String.valueOf(characters).strip();
    }

    class MyCharacter {
        char character;
        int remain;

        public MyCharacter(char character, int remain) {
            this.character = character;
            this.remain = remain;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public int getRemain() {
            return remain;
        }

        public void setRemain(int remain) {
            this.remain = remain;
        }

        @Override
        public String toString() {
            return "MyCharacter{" +
                    "character=" + character +
                    ", remain=" + remain +
                    '}';
        }
    }
}
