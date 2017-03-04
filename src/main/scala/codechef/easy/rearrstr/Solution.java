package codechef.easy.rearrstr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangsenyuan on 04/03/2017.
 */
public class Solution {
    public static void main(String[] args) {
        char[] cand1 = new char[100001];
        char[] cand2 = new char[100000];


        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String str = scanner.nextLine();

            int[] cnt = new int[26];

            int mf = 0;
            for (int i = 0; i < str.length(); i++) {
                cnt[str.charAt(i) - 'a']++;

                if (cnt[str.charAt(i) - 'a'] > mf) {
                    mf = cnt[str.charAt(i) - 'a'];
                }
            }

            if (mf * 2 > str.length() + 1) {
                System.out.println(-1);
                continue;
            }

            List<Pair> pairs = new ArrayList<>();

            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0) {
                    pairs.add(new Pair((char) (i + 'a'), cnt[i]));
                }
            }

            Collections.sort(pairs);

            int top = (str.length() + 1) / 2;

            int pos = 0;
            for (Pair pair : pairs) {
                int y = pair.f;

                while (y-- > 0) {
                    if (pos < top) {
                        cand1[pos++] = pair.c;
                    } else {
                        cand2[pos++ - top] = pair.c;
                    }
                }
            }

            String res = "";
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) {
                    res += cand1[i / 2];
                } else {
                    res += cand2[i / 2];
                }
            }
            System.out.println(res);
        }
    }

    static class Pair implements Comparable<Pair> {
        final char c;
        final int f;

        Pair(char c, int f) {
            this.c = c;
            this.f = f;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.f > that.f) {
                return -1;
            } else if (this.f < that.f) {
                return 1;
            }
            return 0;
        }
    }
}
