package codechef.medium.match2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int q = reader.nextInt();
            int[] A = readNNums(reader, n);
            int[] B = readNNums(reader, n);
            solve(n, q, A, B, reader);
        }
    }

    private static void solve(int n, int Q, int[] A, int[] B, FastReader reader) {
        TreeMap<Integer, Integer> segs = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            segs.put(i, A[i]);
        }
        segs.put(n, 1);
        Map<Integer, Integer> ii = new HashMap<>();
        List<Integer>[] vecs = new List[n];
        for (int i = 0; i < n; i++) {
            vecs[i] = new ArrayList<>();
        }
        int index = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                ans++;
            }
            if (!ii.containsKey(B[i])) {
                ii.put(B[i], index++);
            }
            List<Integer> vec = vecs[ii.get(B[i])];
            vec.add(i);
        }


        for (int q = 0; q < Q; q++) {
            int l = reader.nextInt();
            int r = reader.nextInt();
            int c = reader.nextInt();
            l ^= ans;
            r ^= ans;
            c ^= ans;
            l--;
            r--;
            Map.Entry<Integer, Integer> first = segs.floorEntry(l);

            if (first != null && first.getKey() != l) {
                // l is after this seg
                // seg should never be null, because the segs starting from 0
                // split segs into two [...l), [l...
                segs.put(l, first.getValue());
            }
            Map.Entry<Integer, Integer> last = segs.ceilingEntry(r + 1);
            if (last != null && last.getKey() != r + 1) {
                // split last
                segs.put(r + 1, last.getValue());
            }

            SortedMap<Integer, Integer> wnd = segs.subMap(l, true, r + 1, true);
            //need to remove all keys from wnd, and add a new one
            if (!wnd.isEmpty()) {
                Iterator<Map.Entry<Integer, Integer>> it = wnd.entrySet().iterator();
                Map.Entry<Integer, Integer> prev = it.next();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> cur = it.next();
                    int prevKey = prev.getKey();
                    int prevValue = prev.getValue();
                    if (ii.containsKey(prevValue)) {
                        List<Integer> vec = vecs[ii.get(prevValue)];
                        ans -= count(vec, prevKey, cur.getKey());
                    }
                    prev = cur;
                }

                wnd = segs.subMap(l, r + 1);

                it = wnd.entrySet().iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }


            if (ii.containsKey(c)) {
                ans += count(vecs[ii.get(c)], l, r + 1);
            }
            segs.put(l, c);
            System.out.println(ans);
        }
    }

    private static int count(List<Integer> vec, int left, int right) {
        int i = binarySearch(vec, left);
        int j = binarySearch(vec, right);
        return j - i;
    }

    private static int binarySearch(List<Integer> nums, int num) {
        int left = 0;
        int right = nums.size();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums.get(mid) >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int[] readNNums(FastReader reader, int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextInt();
        }
        return nums;
    }

}


class FastReader {
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
