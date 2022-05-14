package codeforces.set1625.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

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
        //        System.out.println((1 << 30) - 1);
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int K = reader.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = reader.nextInt();
        }
        List<Integer> result = solve(A, K);

        if (result == null) {
            System.out.println("-1");
            return;
        }

        StringBuilder buf = new StringBuilder();
        buf.append(result.size());
        buf.append('\n');
        for (int i = 0; i < result.size(); i++) {
            buf.append(result.get(i));
            buf.append(' ');
        }
        buf.append('\n');
        System.out.print(buf.toString());
    }

    final static int D = 31;

    public static List<Integer> solve(int[] A, int K) {

        int n = A.length;

        int[][] X = new int[n][];
        for (int i = 0; i < n; i++) {
            X[i] = new int[] {A[i], i};
        }

        Arrays.sort(X, (int[] a, int[] b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return 0;
        });

        Node root = new Node(D - 1);

        int best = 0;
        int bestAt = 0;
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int[] cur = X[i];
            int num = cur[0];

            Node node = root;
            int cur_value = 0;
            for (int d = D - 1; d >= 0 && node != null; d--) {
                int u = (K >> d) & 1;
                int v = (num >> d) & 1;
                if (u == 1) {
                    node = node.children[1 ^ v];
                } else {
                    // u == 0;
                    if (node.children[1 ^ v] != null) {
                        if (node.children[1 ^ v].value + 1 >= cur_value) {
                            cur_value = node.children[1 ^ v].value + 1;
                            prev[i] = node.children[1 ^ v].index;
                        }
                    }
                    node = node.children[v];
                }
            }
            if (node != null && node.value + 1 > cur_value) {
                cur_value = node.value + 1;
                prev[i] = node.index;
            }

            if (best < cur_value) {
                best = cur_value;
                bestAt = i;
            }
            root.add(num, cur_value, i);
        }

        if (best == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>(best);
        while (bestAt >= 0) {
            list.add(X[bestAt][1] + 1);
            bestAt = prev[bestAt];
        }

        return list;
    }

    private static class Node {
        Node[] children;
        int value;
        int index;
        int pos;

        public Node(int d) {
            this.pos = d;
            this.children = new Node[2];
            this.value = -1;
        }

        public void add(int num, int v, int i) {
            if (this.pos < 0) {
                if (this.value < v) {
                    this.value = v;
                    this.index = i;
                }
                return;
            }

            int x = (num >> this.pos) & 1;
            if (this.children[x] == null) {
                this.children[x] = new Node(this.pos - 1);
            }
            this.children[x].add(num, v, i);
            int c = x;
            if (this.children[1 ^ x] != null && this.children[1 ^ x].value > this.children[x].value) {
                c = 1 ^ x;
            }
            this.value = this.children[c].value;
            this.index = this.children[c].index;
        }
    }


}
