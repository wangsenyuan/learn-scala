package p218.skyline;

import java.util.*;

/**
 * Created by senyuanwang on 15/5/26.
 */
public class Solution {

    public static void main(String[] args) {
        int[][] buildings = {{0, 5, 7}, {5, 10, 7}, {5, 10, 12}, {10, 15, 7}, {15, 20, 7}, {15, 20, 12}, {20, 25, 7}};

        List<int[]> skyline = getSkyline(buildings);
        for (int[] keyPoint : skyline) {
            System.out.println(keyPoint[0] + ", " + keyPoint[1]);
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return Collections.emptyList();
        }

        final int N = buildings.length;

        final PriorityQueue<Building> endings = new PriorityQueue<>((v1, v2) -> Integer.compare(v1.to, v2.to));
        final PriorityQueue<Integer> heights = new PriorityQueue<>((v1, v2) -> Integer.compare(v2, v1));

        final List<int[]> result = new ArrayList<>();

        // iterate over each of the building
        for (int ind = 0; ind < N; ind++) {

            final Building building = new Building(buildings[ind][0], buildings[ind][1], buildings[ind][2]);

            while (endings.size() > 0 && endings.peek().to < building.from) {
                removeBuildings(endings, heights, result);
            }

            if (heights.size() == 0 || building.height > heights.peek()) {
                result.add(new int[]{building.from, building.height});
            }
            heights.add(building.height);
            endings.add(building);
        }

        while (endings.size() > 0) {
            removeBuildings(endings, heights, result);
        }

        return result;
    }

    private static void removeBuildings(PriorityQueue<Building> endings, PriorityQueue<Integer> heights, List<int[]> result) {
        final Building rm = endings.poll();
        heights.remove(rm.height);
        while (endings.size() > 0 && endings.peek().to == rm.to) {
            heights.remove(endings.poll().height);
        }
        final int peek = heights.size() > 0 ? heights.peek() : 0;
        if (peek < rm.height) {
            result.add(new int[]{rm.to, peek});
        }
    }

    private static class Building {
        private int from;
        private int to;
        private int height;

        public Building(int from, int to, int height) {
            this.from = from;
            this.to = to;
            this.height = height;
        }
    }
}
