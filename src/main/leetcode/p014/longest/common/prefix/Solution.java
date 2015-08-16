package p014.longest.common.prefix;

import java.util.*;

/**
 * Created by senyuanwang on 15/8/16.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int m = Integer.MAX_VALUE;

        for (String str : strs) {
            if (str.length() < m) {
                m = str.length();
            }
        }


        List<Str> list = new ArrayList<>(strs.length * m);

        for (String str : strs) {
            char[] cs = str.toCharArray();

            for (int i = 1; i < cs.length + 1 && i <= m; i++) {
                list.add(new Str(cs, i));
            }
        }

        Collections.sort(list);

        int n = strs.length;

        for (int i = 0; i < list.size(); ) {
            Str current = list.get(i);
            int j = i;
            while (j < list.size() && list.get(j).compareTo(current) == 0) {
                j++;
            }
            if (j - i == n) {
                return current.toString();
            }
            i = j;
        }

        return "";
    }

    static class Str implements Comparable<Str> {
        private final char[] chars;
        private final int end;

        Str(char[] chars, int end) {
            this.chars = chars;
            this.end = end;
        }

        @Override
        public int compareTo(Str that) {
            int i = 0;
            for (; i < this.end && i < that.end; i++) {
                char a = this.chars[i];
                char b = that.chars[i];
                if (a < b) {
                    return 1;
                } else if (a > b) {
                    return -1;
                }
            }

            if (i == this.end && i == that.end) {
                return 0;
            } else if (i == this.end) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return new String(chars, 0, end);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = new String[]{"aa", "a"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}


