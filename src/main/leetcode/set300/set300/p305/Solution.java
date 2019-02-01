package set300.set300.p305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangsenyuan on 25/10/2016.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 8;
        int n = 6;
        int[][] positions =
            {{0, 5}, {5, 4}, {5, 2}, {7, 3}, {6, 0}, {5, 3}, {5, 1}, {1, 3}, {4, 3}, {2, 3}, {3, 5}, {3, 2}, {3, 0},
                {2, 4}, {0, 1}};
        solution.numIslands2(m, n, positions).forEach(System.out::println);
    }

    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, -1, 1, 0};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UF uf = new UF(m * n);

        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            int a = position[0];
            int b = position[1];
            int x = a * n + b;
            uf.set(x);

            for (int k = 0; k < dx.length; k++) {
                int i = a + dx[k];
                int j = b + dy[k];
                if (i < 0 || i >= m || j < 0 || j >= n) {
                    continue;
                }

                int y = i * n + j;
                if (uf.isSet(y)) {
                    uf.union(x, y);
                }
            }

            res.add(uf.size());
        }

        return res;
    }

    static class UF {
        private int[] array;
        private int size;

        public UF(int sz) {
            this.array = new int[sz];
            Arrays.fill(array, -1);
            this.size = 0;
        }

        public int find(int x) {
            if (array[x] == -1) {
                array[x] = x;
            } else if (array[x] != x) {
                array[x] = find(array[x]);
            }
            return array[x];
        }

        public int set(int x) {
            if (this.array[x] >= 0) {
                return size;
            }
            this.array[x] = x;
            size++;
            return size;
        }

        public boolean isSet(int x) {
            return array[x] >= 0;
        }

        public boolean union(int a, int b) {
            int x = find(a);
            int y = find(b);
            if (x == y) {
                return false;
            }
            size--;
            array[x] = y;
            return true;
        }

        public int size() {
            return this.size;
        }
    }
}
