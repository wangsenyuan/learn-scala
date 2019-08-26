package set0000.set300.set310.p316;

import java.util.LinkedList;

/**
 * Created by senyuanwang on 15/12/13.
 */
public class Solution2 {

    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        LinkedList<Integer>[] indexes = new LinkedList[26];

        int totalUniqueLetters = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = c - 'a';

            if (indexes[j] == null) {
                indexes[j] = new LinkedList<>();
                totalUniqueLetters += 1;
            }

            indexes[j].add(i);
        }

        int n = totalUniqueLetters;
        int current = -1;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            OUT:
            for (int i = 0; i < indexes.length; i++) {
                LinkedList<Integer> li = indexes[i];
                if (li == null) {
                    continue;
                }

                while (li.peekFirst() < current) {
                    li.pollFirst();
                }

                for (int j = i + 1; j < indexes.length; j++) {
                    LinkedList<Integer> lj = indexes[j];
                    if (lj == null || li.peekFirst() < lj.peekLast()) {
                        continue;
                    } else {
                        continue OUT;
                    }
                }

                current = li.peekFirst();
                sb.append(s.charAt(current));
                indexes[i] = null;
                n -= 1;
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

//        System.out.println(solution.removeDuplicateLetters("bcabc"));
//        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
        System.out.println(solution2.removeDuplicateLetters("cbac"));

    }
}
