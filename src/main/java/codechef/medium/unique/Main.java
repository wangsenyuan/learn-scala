package codechef.medium.unique;

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
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        String s = reader.next();
        Main main = new Main(s);
        Pair[] res = main.solve();
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d %d\n", res[i].first, res[i].second);
        }
    }


    private static final int MAX_LG = 18;

    private static final int MAX_N = 100003;

    private String S;
    private int N;
    private int[][] o = new int[MAX_LG][2 * MAX_N];
    private int[][] t = new int[2 * MAX_N][2];
    private int[] A = new int[2 * MAX_N];
    private int[] B = new int[2 * MAX_N];
    private int[] C = new int[2 * MAX_N];
    private int[] D = new int[2 * MAX_N];
    private int lj;
    private int ljj;
    private int[] id = new int[MAX_N];
    private TreeMap<Integer, Integer> mem;

    public Main(String S) {
        this.S = S;
        this.N = this.S.length();

        build();

        for (int i = 0; i < N; i++) {
            id[o[lj][i]] = i;
        }

        this.mem = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            this.mem.put(i, i);
        }
    }

    private void build() {
        for (int i = 0; i < N; i++) {
            A[S.charAt(i)] = 1;
        }

        for (int i = 1; i < 300; i++) {
            A[i] += A[i - 1];
        }

        for (int i = 0; i < N; i++) {
            o[0][i] = A[S.charAt(i)];
        }
        lj = 0;
        ljj = 1;
        for (; ljj < N; lj++, ljj <<= 1) {
            Arrays.fill(A, 0);
            Arrays.fill(B, 0);

            for (int i = 0; i < N; i++) {
                A[t[i][0] = o[lj][i]]++;
                if (i + ljj < N) {
                    t[i][1] = o[lj][i + ljj];
                } else {
                    t[i][1] = 0;
                }
                B[t[i][1]]++;
            }

            for (int i = 1; i <= N; i++) {
                A[i] += A[i - 1];
                B[i] += B[i - 1];
            }

            for (int i = N - 1; i >= 0; i--) {
                C[--B[t[i][1]]] = i;
            }
            for (int i = N - 1; i >= 0; i--) {
                D[--A[t[C[i]][0]]] = C[i];
            }
            int k = 1;
            o[lj + 1][D[0]] = k;
            for (int i = 1; i < N; i++) {
                if (t[D[i]][0] != t[D[i - 1]][0] || t[D[i]][1] != t[D[i - 1]][1]) {
                    k++;
                }
                o[lj + 1][D[i]] = k;
            }
        }
    }

    private int lcp(int x, int y) {
        int prf = 0;
        for (int j = lj, jj = ljj; j >= 0; j--, jj >>= 1) {
            if (x < N && j < N && o[j][x] == o[j][y]) {
                x += jj;
                y += jj;
                prf += jj;
            }
        }
        return prf;
    }

    private char getAt(int i) {
        if (i >= N) {
            return '\0';
        }
        return S.charAt(i);
    }

    public Pair[] solve() {
        ArrayList<Pair2> suffs = new ArrayList<>(N);

        for (int i = 1; i <= N; i++) {
            int l = 0;
            if (i > 1) {
                l = Math.max(l, lcp(id[i], id[i - 1]));
            }
            if (i < N) {
                l = Math.max(l, lcp(id[i], id[i + 1]));
            }
            l++;
            if (l <= N - id[i]) {
                suffs.add(new Pair2(l, new Pair(i, id[i])));
            }
        }

        Collections.sort(suffs);

        int[] ansLen = new int[MAX_N];
        int[] ansPos = new int[MAX_N];
        Arrays.fill(ansPos, -1);
        int[] cov = new int[MAX_N];
        Arrays.fill(cov, -1);

        for (int i = 0; i < suffs.size(); i++) {
            int l = suffs.get(i).first;
            int x = suffs.get(i).second.second;
            cov[x + l] = Math.max(cov[x + l], x);

            Map.Entry<Integer, Integer> it = this.mem.ceilingEntry(x);

            while (it != null) {
                int y = it.getKey();
                if (y > x + l - 1) {
                    break;
                }
                ansPos[y] = x;
                ansLen[y] = l;
                this.mem.remove(y);
                it = this.mem.ceilingEntry(y);
            }
        }

        int x = -1;

        for (int i = 0; i < N; i++) {
            x = Math.max(x, cov[i]);

            if (ansPos[i] == -1) {
                ansPos[i] = x;
                ansLen[i] = i - x + 1;
            } else {
                int l = i - x + 1;
                if (x < 0 || ansLen[i] < l) {
                    continue;
                }
                int lc = lcp(ansPos[i], x);
                if (l < ansLen[i] || getAt(x + lc) < getAt(ansPos[i] + lc)) {
                    ansPos[i] = x;
                    ansLen[i] = l;
                }
            }
        }

        Pair[] res = new Pair[N];

        for (int i = 0; i < N; i++) {
            res[i] = new Pair(ansPos[i] + 1, ansLen[i]);
        }

        return res;
    }

    static class Pair implements Comparable<Pair> {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.first != that.first) {
                return this.first - that.first;
            }
            return this.second - that.second;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]").add("first=" + first)
                .add("second=" + second).toString();
        }
    }


    static class Pair2 implements Comparable<Pair2> {
        private final int first;
        private final Pair second;

        private Pair2(int first, Pair second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair2 that) {
            if (this.first != that.first) {
                return this.first - that.first;
            }
            return this.second.compareTo(that.second);
        }
    }
}
