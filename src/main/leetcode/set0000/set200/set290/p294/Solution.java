package set0000.set200.set290.p294;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangsenyuan on 10/10/2016.
 */
public class Solution {
    public boolean canWin(String s) {
        if (s.isEmpty()) {
            return false;
        }
        boolean win = false;

        for (int i = 0; i <= s.length() - 2 && !win; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+' && !canWin(
                s.substring(0, i) + "--" + s.substring(i + 2))) {
                win = true;
            }
        }

        return win;
    }

    public boolean canWin1(String s) {
        s = s.replace('-', ' ');
        int G = 0;
        List<Integer> g = new ArrayList<>();
        for (String t : s.split("[ ]+")) {
            int p = t.length();
            if (p == 0)
                continue;
            while (g.size() <= p) {
                char[] x = t.toCharArray();
                int i = 0, j = g.size() - 2;
                while (i <= j)
                    x[g.get(i++) ^ g.get(j--)] = '-';
                g.add(new String(x).indexOf('+'));
            }
            G ^= g.get(p);
        }
        return G != 0;
    }

    public boolean canWin2(String s) {
        int maxLen = 0;
        int lastPos = 0;
        List<Integer> states = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == '-') {
                if (i - lastPos >= 2) {
                    states.add(i - lastPos);
                }
                if (i - lastPos > maxLen) {
                    maxLen = i - lastPos;
                }
                lastPos = i + 1;
            }
        }

        int[] g = new int[maxLen + 1];
        for (int len = 0; len <= maxLen; len++) {
            Set<Integer> gsub = new HashSet<>();
            for (int len_first_game = 0; len_first_game < len / 2; ++len_first_game) {
                int len_second_game = len - len_first_game - 2;
                // Theorem 2: g[game] = g[subgame1]^g[subgame2]^g[subgame3]...;
                gsub.add(g[len_first_game] ^ g[len_second_game]);
            }
            g[len] = findFirstMissing(gsub);
        }

        int res = 0;

        for (int x : states) {
            res ^= g[x];
        }

        return res != 0;
    }

    private int findFirstMissing(Set<Integer> lut) {
        int m = lut.size();
        for (int i = 0; i < m; ++i) {
            if (!lut.contains(i)) {
                return i;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "++";
        System.out.println(solution.canWin2(str));
    }
}
