package p802;

import java.util.*;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, Boolean>[] rg = new Map[n];
        for (int i = 0; i < n; i++) {
            rg[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                rg[j].put(i, true);
            }
        }

        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j : rg[i].keySet()) {
                degrees[j]++;
            }
        }

        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0) {
                pq.offer(new Item(i, 0));
            }
        }

        List<Integer> res = new ArrayList<>();
        while (pq.size() > 0) {
            Item v = pq.poll();
            if (v.degree > 0) {
                break;
            }
            res.add(v.index);
            int i = v.index;
            for (int j : rg[i].keySet()) {
                degrees[j]--;
                pq.offer(new Item(j, degrees[j]));
            }
        }

        Collections.sort(res);

        return res;
    }

    static class Item implements Comparable<Item> {
        public final int index;
        public final int degree;

        Item(int index, int degree) {
            this.index = index;
            this.degree = degree;
        }

        @Override
        public int compareTo(Item that) {
            if (this.degree < that.degree) {
                return -1;
            } else if (this.degree > that.degree) {
                return 1;
            } else if (this.index < that.index) {
                return -1;
            } else if (this.index > that.index) {
                return 1;
            }
            return 0;
        }
    }
}
