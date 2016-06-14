package p358;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by wangsenyuan on 6/14/16.
 */
public class Solution {
    public String rearrangeString(String str, int k) {
        if (k <= 1) {
            return str;
        }
        int[] times = new int[26];
        for (int i = 0; i < str.length(); i++) {
            ++times[str.charAt(i) - 'a'];
        }
        SortedSet<int[]> set = new TreeSet<>(
            (int[] a, int[] b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0]));

        for (int i = 0; i < 26; i++) {
            if (times[i] != 0) {
                set.add(new int[] {times[i], i});
            }
        }

        int cycles = 0;
        int cur = cycles;
        Iterator<int[]> iter = set.iterator();
        char[] res = new char[str.length()];
        while (iter.hasNext()) {
            int[] e = iter.next();
            for (int i = 0; i < e[0]; i++) {
                res[cur] = (char) ('a' + e[1]);
                if (cur > 0 && res[cur] == res[cur - 1])
                    return "";
                cur += k;
                if (cur >= str.length()) {
                    cur = ++cycles;
                }
            }
        }

        return new String(res);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //        System.out.println(solution.rearrangeString("aabbcc", 3));
        //        System.out.println(solution.rearrangeString("aaadbbcc", 2));
        //        System.out.println(solution.rearrangeString("bbabcaccaaabababbaaaaccbbcbacbacacccbbcaabcbcacaacc", 3));
        System.out.println(solution
            .rearrangeString("bbabcaccaaabababbaaaaccbbcbacbacacccbbcaabcbcacaaccbabbbbbcacccaccbabaccbacabcabcacb",
                2));
    }
}
