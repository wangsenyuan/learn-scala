package leetcodecn.person.tower;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        //        int[] height = {65, 70, 56, 75, 60, 68};
        //        int[] weight = {100, 150, 90, 190, 95, 110};
        //        int[] height = {8378, 8535, 8998, 3766, 648, 6184, 5506, 5648, 3907, 6773};
        //        int[] weight = {9644, 849, 3232, 3259, 5229, 314, 5593, 9600, 6695, 4340};
        int[] height = {5401, 9628, 3367, 6600, 6983, 7853, 5715, 2654, 4453, 8619};
        int[] weight = {3614, 1553, 2731, 7894, 8689, 182, 7632, 4465, 8932, 4304};
        int res = Solution.bestSeqAtIndex(height, weight);
        System.out.println(res);
    }

    public static int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(height[i], weight[i]);
        }

        Arrays.sort(people, (a, b) -> {
            if (a.height > b.height) {
                return -1;
            } else if (a.height < b.height) {
                return 1;
            } else {
                return a.weight - b.weight;
            }
        });

        TreeMap<Integer, Integer> mem = new TreeMap<>();

        int best = 1;
        for (int i = 0; i < n; i++) {
            Person cur = people[i];
            if (mem.isEmpty()) {
                mem.put(cur.weight, 1);
            } else {
                Map.Entry<Integer, Integer> prev = mem.ceilingEntry(cur.weight + 1);
                if (prev == null) {
                    mem.put(cur.weight, 1);
                } else {
                    mem.put(cur.weight, prev.getValue() + 1);
                    //                    mem.remove(prev.getKey());
                }
                int tmp = mem.get(cur.weight);
                Map.Entry<Integer, Integer> next = null;

                while ((next = mem.floorEntry(cur.weight - 1)) != null && next.getValue() <= tmp) {
                    mem.remove(next.getKey());
                }
                best = Math.max(best, tmp);
            }
        }

        return best;
    }

    static class Person {
        final int height;
        final int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}
