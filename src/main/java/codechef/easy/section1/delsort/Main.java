package codechef.easy.section1.delsort;

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
        StringBuilder buf = new StringBuilder();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = reader.nextInt();
            }
            long res = solve(A);
            buf.append(res);
            buf.append('\n');
        }
        System.out.print(buf.toString());
    }

    private static long solve(int[] A) {
        TreeSet<Integer> s1 = new TreeSet<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            s1.add(A[i]);
            if (!left.containsKey(A[i])) {
                left.put(A[i], i);
            }
            right.put(A[i], i);
        }

        long trouble = 0;

        Integer prev = null;
        for (Iterator<Integer> iter = s1.iterator(); iter.hasNext(); ) {
            Integer cur = iter.next();
            if (prev != null) {
                if (right.get(prev) > left.get(cur)) {
                    trouble++;
                }
            }
            prev = cur;
        }
        int n = A.length;
        if (trouble == 0) {
            return 1l * n * (n + 1) / 2;
        }

        Map<Integer, Integer> count = new HashMap<>();
        long ans = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (trouble > 0 && r < n) {
                trouble += remove(s1, left, right, count, A[r]);
                r++;
            }
            if (trouble == 0) {
                ans += n - r + 1;
            }

            trouble += add(s1, left, right, count, A[i]);
        }

        return ans;
    }

    private static int remove(TreeSet<Integer> s, Map<Integer, Integer> left, Map<Integer, Integer> right,
        Map<Integer, Integer> count, Integer x) {
        Integer c = count.get(x);
        //只有将x第一次删除掉时，需要处理它的左右数值
        int delta = 0;
        if (c == null || c == 0) {
            s.remove(x);
            Integer r = s.ceiling(x);
            Integer l = s.floor(x);
            if (l != null && right.get(l) > left.get(x)) {
                // 删除x后, 减少了一个逆序对
                delta--;
            }
            if (r != null && right.get(x) > left.get(r)) {
                delta--;
            }

            if (l != null && r != null && right.get(l) > left.get(r)) {
                delta++;
            }
        }

        count.put(x, c == null ? 1 : c + 1);

        return delta;
    }

    public static int add(TreeSet<Integer> s, Map<Integer, Integer> left, Map<Integer, Integer> right,
        Map<Integer, Integer> count, Integer x) {
        Integer c = count.get(x);
        // c can't be null
        count.put(x, c - 1);
        int delta = 0;
        if (c == 1) {
            Integer r = s.ceiling(x);
            Integer l = s.floor(x);

            if (l != null && right.get(l) > left.get(x)) {
                delta++;
            }

            if (r != null && right.get(x) > left.get(r)) {
                delta++;
            }

            if (l != null && r != null && right.get(l) > left.get(r)) {
                delta--;
            }
            s.add(x);
        }
        return delta;
    }
}
