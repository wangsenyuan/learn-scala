package codechef.easy.section1.dakimaku;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //SOLUTION BEGIN
    void pre() throws Exception {
    }

    void solve(int TC) throws Exception {
        int N = ni();
        long X = nl();
        long[] C = new long[1 + N], T = new long[1 + N];
        for (int i = 1; i <= N; i++)
            C[i] = nl();
        for (int i = 1; i <= N - 1; i++)
            T[i] = nl();
        long lo = 1, hi = (long) 1e18;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (cost(N, C, T, mid) <= X)
                hi = mid;
            else
                lo = mid + 1;
        }
        pn(hi);
    }

    //Minimum cost to ensure delivery in time X
    long cost(int N, long[] C, long[] T, long ti) {
        long[] DP = new long[1 + N];//DP[i] = Minimum coins needed for first i cities, if there's a branch at city i
        Arrays.fill(DP, Long.MAX_VALUE / 2);
        DP[0] = 0;
        for (int i = 1; i <= N; i++) {
            List<long[]> list = new ArrayList<>();
            long dist = 0;//, sum = 0;
            for (int j = i; j > 0; j--) {
                //[j, i] are dealt by a branch at city i
                if (C[j] > 0)
                    list.add(new long[] {C[j], dist + 1});
                dist += T[j - 1];
                DP[i] = Math.min(DP[i], DP[j - 1] + minProductivityNeeded(list, ti));
            }
        }
        return DP[N];
    }

    //finding the minimum productivity needed to serve all people upto maxTime
    long minProductivityNeeded(List<long[]> people, long maxTime) {
        long minProd = 0;
        long sum = 0;
        for (int i = people.size() - 1; i >= 0; i--) {
            sum += people.get(i)[0];
            long ti = people.get(i)[1];
            if (ti > maxTime)
                return Long.MAX_VALUE / 2;//T <= Ti
            long di = (maxTime - ti + 1);
            //sum = sum C[k] for i <= k <= j
            minProd = Math.max(minProd, (sum + di - 1) / di);
        }
        return minProd;
    }

    //SOLUTION END
    void hold(boolean b) throws Exception {
        if (!b)
            throw new Exception("Hold right there, Sparky!");
    }

    static boolean multipleTC = true;
    FastReader in;
    PrintWriter out;

    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        //Solution Credits: Taranpreet Singh
        int T = (multipleTC) ? ni() : 1;
        pre();
        for (int t = 1; t <= T; t++)
            solve(t);
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    int bit(long n) {
        return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
    }

    void p(Object o) {
        out.print(o);
    }

    void pn(Object o) {
        out.println(o);
    }

    void pni(Object o) {
        out.println(o);
        out.flush();
    }

    String n() throws Exception {
        return in.next();
    }

    String nln() throws Exception {
        return in.nextLine();
    }

    int ni() throws Exception {
        return Integer.parseInt(in.next());
    }

    long nl() throws Exception {
        return Long.parseLong(in.next());
    }

    double nd() throws Exception {
        return Double.parseDouble(in.next());
    }

    class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception {
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }
    }
}
