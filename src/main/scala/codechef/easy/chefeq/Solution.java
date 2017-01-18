package codechef.easy.chefeq;

import java.util.Scanner;

/**
 * Created by senyuanwang on 2017/1/18.
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while (t > 0) {
                int n = scanner.nextInt();
                int[] freq = new int[100001];
                for (int i = 0; i < n; i++) {
                    int x = scanner.nextInt();
                    freq[x]++;
                }

                int x = 0;
                for (int i = 0; i < freq.length; i++) {
                    if (x < freq[i]) {
                        x = freq[i];
                    }
                }

                System.out.println(n - x);

                t--;
            }
        }
    }
}
