package codechef.medium.manylst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
        String res = solve(reader);
        System.out.print(res);
    }

    static int[] array;

    private static void modify(int n, int p, int v) {
        //        p++;
        while (p <= n) {
            array[p] += v;
            p += p & -p;
        }
    }

    private static int query(int p) {
        int res = 0;
        while (p > 0) {
            res += array[p];
            p -= p & -p;
        }
        return res;
    }

    public static String solve(FastReader reader) {
        int n = reader.nextInt();
        int q = reader.nextInt();
        array = new int[n + 1];
        TreeMap<Integer, Integer>[] appears = new TreeMap[n + 1];
        for (int i = 0; i <= n; i++) {
            appears[i] = new TreeMap<>();
        }

        StringBuilder res = new StringBuilder();
        while (q-- > 0) {
            int tp = reader.nextInt();
            if (tp == 0) {
                int l = reader.nextInt();
                int r = reader.nextInt();
                int x = reader.nextInt();

                Map.Entry<Integer, Integer> entry = appears[x].floorEntry(l);
                if (entry != null && entry.getValue() >= r) {
                    l = entry.getKey();
                }

                while (true) {
                    entry = appears[x].ceilingEntry(l);
                    if (entry == null || entry.getKey() > r) {
                        break;
                    }
                    r = Math.max(r, entry.getValue());
                    modify(n, entry.getKey(), -1);
                    modify(n, entry.getValue() + 1, 1);
                    appears[x].remove(entry.getKey());
                }

                appears[x].put(l, r);
                modify(n, l, 1);
                modify(n, r + 1, -1);
            } else {
                int j = reader.nextInt();
                res.append(query(j));
                res.append('\n');
            }
        }

        return res.toString();
    }
}
