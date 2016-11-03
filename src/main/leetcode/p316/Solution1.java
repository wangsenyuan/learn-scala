package p316;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by wangsenyuan on 03/11/2016.
 */
public class Solution1 {

    public String removeDuplicateLetters(String s) {
        int map[] = new int[26];
        boolean appeared[] = new boolean[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        Deque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (appeared[c - 'a']) {
                map[c - 'a'] = map[c - 'a'] - 1;
                continue;
            }

            while (dq.size() > 0 && dq.peekLast() > c && map[dq.peekLast() - 'a'] > 1) {
                appeared[dq.peekLast() - 'a'] = false;
                map[dq.peekLast() - 'a'] = map[dq.peekLast() - 'a'] - 1;
                dq.pollLast();

            }
            dq.offerLast(c);
            appeared[c - 'a'] = true;

        }

        StringBuilder res = new StringBuilder();
        appeared = new boolean[26];
        while (dq.size() > 0) {
            char c = dq.pollFirst();
            if (!appeared[c - 'a'])
                res.append(c);
            appeared[c - 'a'] = true;
        }

        return res.toString();
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        //        System.out.println(solution.removeDuplicateLetters("bcabc"));
        //        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
        System.out.println(solution.removeDuplicateLetters("cbac"));

    }
}

