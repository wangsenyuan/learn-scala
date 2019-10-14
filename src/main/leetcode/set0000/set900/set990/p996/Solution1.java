package set0000.set900.set990.p996;

import java.util.Arrays;

public class Solution1 {
    int count = 0;
    int[] buf = new int[12];

    public int numSquarefulPerms(int[] A) {
        int n = A.length;
        if (n < 2)
            return 0;
        Arrays.sort(A);
        dfs(A, 0, -1, new boolean[n], n);
        return count;
    }

    private void dfs(int[] A, int nums, int last, boolean[] visited, int n) {
        if (nums == n) {
            for (int i = 0; i < n; i++) {
                System.err.printf("%d ", buf[i]);
            }
            System.err.println();
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            if (i > 0 && A[i] == A[i - 1] && !visited[i - 1])
                continue;
            if (last == -1) {
                visited[i] = true;
                buf[nums] = A[i];
                dfs(A, nums + 1, A[i], visited, n);
                visited[i] = false;
            } else {
                int sum = last + A[i];
                int temp = (int) Math.sqrt(sum);
                if (temp * temp != sum)
                    continue;
                visited[i] = true;
                buf[nums] = A[i];
                dfs(A, nums + 1, A[i], visited, n);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.numSquarefulPerms(new int[] {0, 0, 0, 1, 1, 1}));
    }
}
