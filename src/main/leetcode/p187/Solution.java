package p187;

import java.util.*;

/**
 * Created by senyuanwang on 15/3/14.
 */
public class Solution {

    public static void main(String[] args) {
        List<String> list = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String str : list) {
            System.out.println(str);
        }
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() == 0) {
            return Collections.emptyList();
        }

        char[] chars = s.toCharArray();
        List<Seq> seqList = new ArrayList<Seq>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            Seq seq = new Seq(chars, i);
            seqList.add(seq);
        }

        Collections.sort(seqList);

        List<String> result = new ArrayList<String>(seqList.size());
        Set<String> inResult = new HashSet<>();
        for (int i = 1; i < seqList.size(); i++) {
            Seq prev = seqList.get(i - 1);
            if (prev.length < 10) {
                continue;
            }
            Seq curr = seqList.get(i);
            String prevStr = prev.toString();
            String currStr = curr.toString();
            if (prevStr.equals(currStr) && !inResult.contains(currStr)) {
                result.add(currStr);
                inResult.add(currStr);
            }
        }
        return result;
    }

    static class Seq implements Comparable<Seq> {
        final char[] chars;
        final int offset;
        final int length;
        private String strRep;

        public Seq(char[] chars, int offset) {
            this.chars = chars;
            this.offset = offset;
            int len = chars.length - offset;
            this.length = len >= 10 ? 10 : len;
        }


        @Override
        public int compareTo(Seq that) {
            if (this.length < that.length) {
                return -1;
            } else if (this.length > that.length) {
                return 1;
            }

            int cmp = 0;
            int i = 0;
            int j = 0;
            for (; cmp == 0 && i < this.length && j < that.length; i++, j++) {
                char thisc = chars[i + this.offset];
                char thatc = chars[j + that.offset];
                if (thisc < thatc) {
                    cmp = -1;
                } else if (thisc > thatc) {
                    cmp = 1;
                } else {
                    cmp = 0;
                }
            }

            if (cmp != 0) {
                return cmp;
            } else if (j < that.length) {
                return -1;
            } else if (i < this.length) {
                return 1;
            } else {
                return 0;
            }
        }

        public String toString() {
            if (strRep == null) {
                strRep = new String(chars, offset, length);
            }
            return strRep;
        }
    }
}
