package set0000.set100.set130.p131;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangsenyuan on 8/18/16.
 */
public class Solution1 {
    public static void main(String[] args) {
        String s = "abcadac";
        List<List<String>> result = partition(s);
        for (List<String> each : result) {
            System.out.println(String.join(",", each));
        }
    }

    public static List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }

        int n = s.length();
        char[] cs = s.toCharArray();
        boolean[][] fx = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n && cs[i - j] == cs[i + j]; j++) {
                fx[i - j][i + j] = true;
            }

            for (int j = 1; i - j + 1 >= 0 && i + j < n && cs[i - j + 1] == cs[i + j]; j++) {
                fx[i - j + 1][i + j] = true;
            }
        }

        List<List<String>> result = new ArrayList<>();
        doPartition(cs, 0, fx, new ArrayList<>(), result);
        return result;
    }

    private static void doPartition(char[] cs, int i, boolean[][] fx, List<String> path, List<List<String>> result) {
        if (i == cs.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int len = 0; i + len < cs.length; len++) {
            int j = i + len;
            if (!fx[i][j]) {
                continue;
            }
            path.add(new String(cs, i, len + 1));
            doPartition(cs, j + 1, fx, path, result);
            path.remove(path.size() - 1);
        }
    }
}
