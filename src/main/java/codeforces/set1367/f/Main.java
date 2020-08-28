package codeforces.set1367.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = reader.nextInt();
            }
            System.out.println(solve(n, A));
        }
    }

    public static int solve(int n, int[] A) {
        // 找到数组中最长的连续递增子序列，然后将其他的移动到前端或者后端
        int[][] vec = new int[n][];
        for (int i = 0; i < n; i++) {
            vec[i] = new int[] {A[i], -i};
        }

        Arrays.sort(vec, (a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            } else if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            return 0;
        });

        TreeSet<Integer> s1 = new TreeSet<>();
        TreeSet<Integer> s2 = new TreeSet<>();

        int best = 0;

        int i = 0;
        for (int j = 0; j < n; j++) {
            if (vec[j][0] != vec[j - s1.size()][0]) {
                s2.addAll(s1);
                s1.clear();
            }
            //判断s2里面最靠右的元素的位置，是不是在当前元素位置的后面
            while (s2.size() > 0 && s2.first() < vec[j][1]) {
                s2.remove(vec[i][1]);
                i++;
            }
            s1.add(vec[j][1]);

            best = Math.max(best, s1.size() + s2.size());
        }

        return n - best;
    }

}
