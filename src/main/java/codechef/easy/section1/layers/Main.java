package codechef.easy.section1.layers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();

        while (tc-- > 0) {
            int n = reader.nextInt();
            int c = reader.nextInt();
            int[][] rects = new int[n][3];

            for (int i = 0; i < n; i++) {
                rects[i][0] = reader.nextInt();
                rects[i][1] = reader.nextInt();
                rects[i][2] = reader.nextInt();
            }

            long[] res = solve(n, c, rects);

            for (int i = 0; i < n; i++) {
                if (i < n - 1) {
                    System.out.printf("%d ", res[i]);
                } else {
                    System.out.printf("%d\n", res[i]);
                }
            }
        }
    }

    public static long[] solve(int n, int C, int[][] rects) {
        TreeSet<Node> set = new TreeSet<>();
        set.add(new Node(0, Long.MAX_VALUE));
        set.add(new Node(Long.MAX_VALUE, 0));

        ArrayList<Node> vec = new ArrayList<>();

        long[] res = new long[C];

        for (int i = 0; i < n; i++) {
            int[] rect = rects[i];
            int x = rect[0];
            int y = rect[1];
            int c = rect[2];

            SortedSet<Node> ss = set.headSet(new Node(x, Long.MIN_VALUE));

            // ss can't be empty
            Iterator<Node> it = ss.iterator();
            Node cur = it.next();
            if (cur.y < y) {
                vec.add(new Node(x, cur.y));
            }

            while (it.hasNext() && (cur = it.next()) != null && cur.x < x && cur.y < y) {
                vec.add(cur);
            }

            if (cur.x < x) {
                vec.add(new Node(cur.x, y));
            }

            for (Node node : vec) {
                set.remove(node);
            }

            long tmp = 0;
            for (int j = 0; j < vec.size() - 1; j++) {
                tmp += (vec.get(j).x - vec.get(j + 1).x) * (y - vec.get(j).y);
            }

            if (tmp > 0) {
                set.add(new Node(x, y));
            }
            res[c - 1] += tmp;

            vec.clear();
        }

        return res;
    }

    static class Node implements Comparable<Node> {
        long x;
        long y;

        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Node that) {
            if (this.x < that.x) {
                return -1;
            }
            if (this.x > that.x) {
                return 1;
            }

            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
