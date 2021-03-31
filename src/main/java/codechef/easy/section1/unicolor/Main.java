package codechef.easy.section1.unicolor;

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
            int c = reader.nextInt();
            int n = reader.nextInt();
            int m = reader.nextInt();
            List<Event> events = new ArrayList<>(c);
            for (int i = 0; i < c; i++) {
                int x = reader.nextInt();
                for (int j = 0; j < 2 * x; j += 2) {
                    int pos = reader.nextInt();
                    Event cur = new Event(1, pos, i);
                    events.add(cur);
                    pos = reader.nextInt();
                    cur = new Event(-1, pos + 1, i);
                    events.add(cur);
                }
            }
            int res = solve(c, n, m, events);
            System.out.println(res);
        }
    }


    private static final long MOD = 998244353;

    public static int solve(int C, int N, int M, List<Event> E) {
        Collections.sort(E);
        Set<Integer> active = new HashSet<>();

        UF uf = new UF(C);

        int prev = 1;
        int free = 0;
        int level = 0;
        for (Event cur : E) {
            if (cur.type < 0) {
                active.remove(cur.club);
                level--;
                prev = cur.pos;
                continue;
            }
            if (level == 0) {
                free += cur.pos - prev;
            }
            level++;
            for (Integer x : active) {
                uf.union(x, cur.club);
            }

            active.add(cur.club);

            prev = cur.pos;
        }

        free += N + 1 - prev;

        return pow(M, free + uf.size);
    }

    private static final int pow(int a, int b) {
        long res = 1;
        long A = a;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * A) % MOD;
            }
            A = (A * A) % MOD;
            b >>= 1;
        }
        return (int) res;
    }

    static class Event implements Comparable<Event> {
        final int type;
        final int pos;
        final int club;

        Event(int type, int pos, int club) {
            this.type = type;
            this.pos = pos;
            this.club = club;
        }

        @Override
        public int compareTo(Event that) {
            if (this.pos < that.pos) {
                return -1;
            }
            if (this.pos > that.pos) {
                return 1;
            }
            if (this.type < that.type) {
                return -1;
            }
            if (this.type > that.type) {
                return 1;
            }
            return 0;
        }
    }


    static class UF {
        private final int[] array;
        private final int[] count;
        private int size;

        public UF(int sz) {
            this.array = new int[sz];
            this.count = new int[sz];
            for (int i = 0; i < sz; i++) {
                array[i] = i;
                count[i]++;
            }
            this.size = sz;
        }

        public int find(int x) {
            int p = this.array[x];
            if (p == x) {
                return x;
            }
            this.array[x] = find(p);
            return this.array[x];
        }

        public void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a == b) {
                return;
            }
            if (count[a] < count[b]) {
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
            }
            count[a] += count[b];
            array[b] = a;
            size--;
        }

    }


}
