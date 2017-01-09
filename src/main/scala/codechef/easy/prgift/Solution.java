package codechef.easy.prgift;

import java.util.Scanner;

/**
 * Created by wangsenyuan on 15/12/2016.
 */
public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while (t > 0) {
                t--;
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    int x = scanner.nextInt();
                    if (x % 2 == 0) {
                        cnt++;
                    }
                }

                if (k > 0 && cnt >= k) {
                    System.out.println("YES");
                } else if (k == 0 && cnt < n) {
                    //if no favor nof even numbers, then only give a non-empty odd number segment to frient
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
