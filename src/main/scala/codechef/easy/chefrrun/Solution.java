package codechef.easy.chefrrun;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.nextLine();

        int[] checked = new int[n];
        for (int i = 0; i < n; i++) {
            if (checked[i] == 0) {
                int j = i;
                while (checked[j] < 2) {
                    checked[j]++;
                    j = (j + A[j] + 1) % n;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (checked[i] == 2) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
