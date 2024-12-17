package org.example.nov2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindChampionII2924 {
    static class Dump {
        public int findChampion(int n, int[][] edges) {
            List<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
            }
            boolean[] visited = new boolean[n];
            boolean[] status = new boolean[n];
            Arrays.fill(status, true);
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }

                List<Integer> childs = graph[i];
                if (!childs.isEmpty()) {
                    traverse(queue, visited, status, childs, graph);
                }
            }

            int count = 0;
            int lastIndex = -1;
            for (int i = 0; i < n; i++) {
                if (status[i]) {
                    count++;
                    lastIndex = i;
                }
            }
            return count == 1 ? lastIndex : -1;
        }

        private void traverse(Queue<Integer> queue, boolean[] visited, boolean[] status, List<Integer> childs, List<Integer>[] graph) {
            for (var child : childs) {
                if (visited[child]) {
                    continue;
                }
                visited[child] = true;
                status[child] = false;
                queue.add(child);
            }

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                visited[poll] = true;
                status[poll] = false;
                var nextChild = graph[poll];
                for (var child : nextChild) {
                    if (visited[child]) {
                        continue;
                    }
                    queue.add(child);
                }
            }
        }
    }

    class Intelligence {
        public int findChampion(int n, int[][] edges) {
            int[] counts = new int[n];
            for (int[] edge : edges) {
                counts[edge[1]]++;
            }

            int count = 0;
            int lastIndex = -1;
            for (int i = 0; i < n; i++) {
                if (counts[i] == 0) {
                    lastIndex = i;
                    count++;
                }
            }
            return count == 1 ? lastIndex : -1;
        }
    }
}
