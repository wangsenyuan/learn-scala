package codechef.medium.kol15c;

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
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int u = fastReader.nextInt();
        int sq = (int) Math.sqrt(n);

        int[] A = new int[n + 1];

        Map<Integer, List<Integer>> todos = new HashMap<>();

        for (int i = 0; i < u; i++) {
            int a = fastReader.nextInt();
            int b = fastReader.nextInt();
            if (a >= sq) {
                for (int j = 0; j * a + b <= n; j++) {
                    A[j * a + b]++;
                }
            } else {
                if (!todos.containsKey(a)) {
                    todos.put(a, new ArrayList<>());
                }
                todos.get(a).add(b);
            }
        }

        for (int a : todos.keySet()) {
            process(A, a, todos.get(a));
        }

        for (int i = 1; i <= n; i++) {
            if (i < n) {
                System.out.printf("%d ", A[i]);
            } else {
                System.out.printf("%d\n", A[i]);
            }
        }
    }

    static void process(int[] A, int a, List<Integer> bs) {
        int[] C = new int[A.length];
        for (int b : bs) {
            C[b]++;
        }

        for (int i = 1; i < A.length; i++) {
            if (i >= a) {
                C[i] += C[i - a];
            }
            A[i] += C[i];
        }
    }
}
