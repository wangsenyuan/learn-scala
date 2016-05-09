package p37;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by senyuanwang on 16/5/8.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] f = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        boolean[][] p = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            p[i] = new boolean[n];
        }
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                int y = nums[j];
                if (x >= y) {
                    continue;
                }
                if (f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                    Arrays.fill(p[i], false);
                    p[i][j] = true;
                } else if (f[j] + 1 == f[i]) {
                    p[i][j] = true;
                }
            }
        }

        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, f[i]);
        }
        Set<String> paths = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (f[i] < mx) {
                continue;
            }

            paths.addAll(dfs(i, nums, p, ""));
        }

        System.out.println(mx + " " + paths.size());
    }

    public static Set<String> dfs(int i, int[] nums, boolean[][] p, String path) {
        int x = nums[i];
        Set<String> paths = new HashSet<>();
        boolean hasSubPath = false;
        for (int j = 0; j < p[i].length; j++) {
            if (p[i][j]) {
                hasSubPath = true;
                paths.addAll(dfs(j, nums, p, path + "|" + x));
            }
        }
        if (!hasSubPath) {
            paths.add(path);
        }
        return paths;
    }

}
