package set100.set120.p127;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangsenyuan on 8/17/16.
 */
public class SolutionTLE {

    public static void main(String[] args) {
        Set<String> wordList = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        SolutionTLE solution = new SolutionTLE();
        System.out.println(solution.ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();

        graph.put(beginWord, new HashSet<>());
        for (String a : wordList) {
            if (canTransform(beginWord, a)) {
                graph.get(beginWord).add(a);
            }

            if (!graph.containsKey(a)) {
                graph.put(a, new HashSet<>());
            }
            for (String b : wordList) {
                if (a.equals(b)) {
                    continue;
                }
                if (canTransform(a, b)) {
                    graph.get(a).add(b);
                }
            }

            if (canTransform(a, endWord)) {
                graph.get(a).add(endWord);
            }
        }

        int[] result = {Integer.MAX_VALUE};

        dfs(endWord, beginWord, graph, new HashSet<>(), 0, result);

        if (result[0] == Integer.MAX_VALUE) {
            return 0;
        }
        return result[0] + 1;
    }

    private void dfs(String target, String root, Map<String, Set<String>> graph, Set<String> visited, int path,
        int[] result) {
        if (target.equals(root)) {
            if (path < result[0]) {
                result[0] = path;
            }
            return;
        }

        visited.add(root);

        for (String neighbor : graph.get(root)) {
            if (visited.contains(neighbor)) {
                continue;
            }
            dfs(target, neighbor, graph, visited, path + 1, result);
        }


        visited.remove(root);
    }


    private boolean canTransform(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }

        return true;
    }


}
