package p014.longest.common.prefix;

import java.util.*;

/**
 * Created by senyuanwang on 15/8/16.
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

//        Arrays.sort(strs);

        String min = null;

        for (String str : strs) {
            if (min == null) {
                min = str;
            } else if (min.length() > str.length()) {
                min = str;
            }
        }
        for (int i = 0; i < min.length(); i++) {
            char c = min.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return min;
    }

    public String longestCommonPrefix1(String[] strs) {
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
            int j = findLastSame(current, list, i, i + n);
            if (j - i == n) {
                return current.toString();
            }
            i = j;
        }

        return "";
    }

    private int findLastSame(Str target, List<Str> list, int start, int end) {
        int i = start, j = end <= list.size() ? end - 1 : list.size() - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            Str theMid = list.get(mid);
            if (theMid.compareTo(target) == 0) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return i;
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
        String[] strs = {"aa", "a"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}


