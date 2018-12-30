package set100.set120.p127;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
            new FileReader("src/main/leetcode/set100.set120.p127/word_ladder_dict_3.txt"))) {
            HashSet<String> dict = new HashSet<String>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                dict.add(line);
            }
            long start = System.currentTimeMillis();
            //			ArrayList<ArrayList<String>> ladders = findLadders("charge",
            //					"comedo", dict);
            //			ArrayList<ArrayList<String>> ladders = findLadders("hit", "cog",
            //					dict);

            //			ArrayList<ArrayList<String>> ladders = findLadders("nape", "mild",
            //					dict);
            List<List<String>> ladders = findLadders("red", "tax", dict);
            long period = System.currentTimeMillis() - start;
            System.out.println("it taks [" + period + "] milliseconds to process");
            for (List<String> ladder : ladders) {
                String sep = "";
                for (String word : ladder) {
                    System.out.print(sep + word);
                    if (sep == "") {
                        sep = "->";
                    }
                }
                System.out.println();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> set1 = new HashSet<>();
        set1.add(beginWord);

        Set<String> set2 = new HashSet<>();
        set2.add(endWord);

        wordList.remove(beginWord);
        wordList.remove(endWord);

        return minLengthBidirectionalSearch(set1, set2, wordList, 2);
    }

    public int minLengthBidirectionalSearch(Set<String> set1, Set<String> set2, Set<String> wordList, int length) {
        if (set1.size() == 0) {
            return 0;
        }

        Set<String> newSet = new HashSet<>();

        for (String s : set1) {
            char[] str = s.toCharArray();
            for (int j = 0; j < str.length; j++) {
                char og = str[j];
                for (char c = 'a'; c <= 'z'; c++) {
                    str[j] = c;
                    String newStr = String.valueOf(str);
                    if (set2.contains(newStr)) {
                        return length;
                    }
                    if (wordList.contains(newStr)) {
                        newSet.add(newStr);
                        wordList.remove(newStr);
                    }
                }
                str[j] = og;
            }
        }

        // This part is KEY to bringing your run-time down. Otherwise sets with more neighbours
        // will skew the benefit that can be obtained from searching outward from two nodes.
        if (newSet.size() < set2.size()) {
            return minLengthBidirectionalSearch(newSet, set2, wordList, length + 1);
        } else {
            return minLengthBidirectionalSearch(set2, newSet, wordList, length + 1);
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String, ArrayList<String>> h = new HashMap();
        Set<String> set1 = new HashSet(), set2 = new HashSet();
        set1.add(beginWord);
        set2.add(endWord);
        BFS(set1, set2, wordList, h, true);

        List<List<String>> ans = new ArrayList();
        List<String> cur = new ArrayList();
        cur.add(beginWord);
        DFS(beginWord, endWord, h, cur, ans);
        return ans;
    }

    private static void BFS(Set<String> set1, Set<String> set2, Set<String> wordList,
        HashMap<String, ArrayList<String>> h, boolean forward) {
        if (set1.size() > set2.size()) {
            BFS(set2, set1, wordList, h, !forward);
            return;
        }
        wordList.removeAll(set1);
        wordList.removeAll(set2);
        boolean connected = false;
        Set<String> set3 = new HashSet();

        for (String s : set1) {
            char[] c = s.toCharArray();
            for (int i = 0, len = c.length; i < len; i++) {
                char ch = c[i];
                for (char x = 'a'; x <= 'z'; x++)
                    if (x != ch) {
                        c[i] = x;
                        String cand = new String(c);
                        if (set2.contains(cand) || (!connected && wordList.contains(cand))) {
                            if (set2.contains(cand))
                                connected = true;
                            else
                                set3.add(cand);

                            String cand1 = forward ? cand : s;
                            String s1 = forward ? s : cand;
                            ArrayList<String> cur = h.containsKey(s1) ? h.get(s1) : new ArrayList();
                            cur.add(cand1);
                            h.put(s1, cur);
                        }
                    }
                c[i] = ch;
            }
        }
        if (!connected && !set3.isEmpty())
            BFS(set3, set2, wordList, h, forward);
    }

    private static void DFS(String str, String ed, HashMap<String, ArrayList<String>> h, List<String> cur,
        List<List<String>> ans) {
        if (str.equals(ed)) {
            ans.add(new ArrayList(cur));
            return;
        }

        if (!h.containsKey(str))
            return;
        List<String> next = h.get(str);
        for (String i : next) {
            cur.add(i);
            DFS(i, ed, h, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
