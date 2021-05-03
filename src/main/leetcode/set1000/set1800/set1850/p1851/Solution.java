package set1000.set1800.set1850.p1851;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            }
            if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        Pair[] qs = new Pair[queries.length];

        for (int i = 0; i < queries.length; i++) {
            qs[i] = new Pair(queries[i], i);
        }

        Arrays.sort(qs, (a, b) -> {
            if (a.first < b.first) {
                return -1;
            }
            if (a.first > b.first) {
                return 1;
            }
            return 0;
        });

        Arrays.sort(queries);

        TreeSet<Pair> active = new TreeSet<>();
        TreeSet<Pair> pp = new TreeSet<>();

        int[] ans = new int[qs.length];

        for (int i = 0, j = 0; i < qs.length; i++) {

            while (pp.size() > 0) {
                Pair head = pp.first();
                if (head.first >= qs[i].first) {
                    // head is still active
                    break;
                }
                int p = head.second;
                int l = intervals[p][1] - intervals[p][0] + 1;
                pp.remove(head);
                active.remove(new Pair(l, p));
            }

            while (j < intervals.length && intervals[j][0] <= qs[i].first) {
                int[] cur = intervals[j];
                if (cur[1] >= qs[i].first) {
                    active.add(new Pair(cur[1] - cur[0] + 1, j));
                    pp.add(new Pair(cur[1], j));
                }
                j++;
            }

            if (active.size() == 0) {
                ans[qs[i].second] = -1;
                continue;
            }
            Pair tmp = active.first();
            ans[qs[i].second] = tmp.first;
        }

        return ans;
    }

    static class Pair implements Comparable<Pair> {
        final int first;
        final int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair that) {
            return compare(this, that);
        }


    }

    private static int compare(Pair a, Pair b) {
        // first is length
        if (a.first < b.first) {
            return -1;
        }
        if (a.first > b.first) {
            return 1;
        }
        // second is index
        if (a.second < b.second) {
            return -1;
        }
        if (a.second > b.second) {
            return 1;
        }
        return 0;
    }

}
