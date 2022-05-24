package codechef.easy.section1.amr16c;

import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef {


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

    public static void main(String[] args) throws java.lang.Exception {
        init();

        FastReader reader = new FastReader();

        int tc = reader.nextInt();

        StringBuilder buf = new StringBuilder();

        while (tc-- > 0) {
            int n = reader.nextInt();
            long[] P = new long[n];
            for (int i = 0; i < n; i++) {
                P[i] = reader.nextLong();
            }
            List<Integer> result = solve(P);
            if (result.isEmpty()) {
                buf.append("No supporter found.\n");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    buf.append(result.get(i));
                    buf.append(' ');
                }
                buf.append('\n');
            }
        }

        System.out.print(buf);
    }

    private final static long MAX_X = 1000010;
    private final static long MAX_Y = MAX_X * MAX_X;
    private static Set<Long> candiates;

    private static void init() {
        candiates = new HashSet<>();
        BitSet set = new BitSet();
        for (int x = 2; x < MAX_X; x = set.nextClearBit(x + 1)) {
            // x is a prime;
            long X = (long) x;
            for (long y = X * X; y < MAX_Y; y *= X) {
                candiates.add(y);
                if (y >= MAX_Y / X) {
                    // avoiding overflow
                    break;
                }
            }
            for (int y = 2 * x; y < MAX_X; y += x) {
                set.set(y);
            }
        }
    }

    public static List<Integer> solve(long[] P) {
        int n = P.length;
        Set<Integer> support = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long x = P[i];
            // if x have more than 2 prime factors, it will not have prime count of factors
            // let's say it has a & b, (both primes), ca, cb count of a prime factors, as well as b
            // then the count of primes will have (ca + 1) * (cb + 1), definitely not a prime;
            // so, x has to have only one prime factors;
            // and if x is a prime, will also not a support, as it's factor count would be 2, which is even;
            if (candiates.contains(x)) {
                support.add(i);
            }
        }

        if (support.size() == 0) {
            return new ArrayList<>();
        }

        List<Pair> all = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            all.add(new Pair(P[i], i));
        }

        Collections.sort(all);

        List<Integer> result = new ArrayList<>(support.size());

        for (int i = 0; i < n; i++) {
            Pair cur = all.get(i);
            if (support.contains(cur.second)) {
                result.add(i + 1);
            }
        }
        return result;
    }

    static class Pair implements Comparable<Pair> {
        final long first;
        final int second;

        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.first < that.first) {
                return 1;
            }
            if (this.first > that.first) {
                return -1;
            }
            return 0;
        }
    }


}

