package codechef.easy.bex;

import java.util.Scanner;

/**
 * Created by wangsenyuan on 13/03/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] xs = new int[n];
        String[] names = new String[n];
        int[] ts = new int[n];
        int p = 0;
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.equals("-1")) {
                System.out.printf("%d %s\n", ts[p - 1], names[p - 1]);
                p--;
                continue;
            }
            String[] strs = line.split("\\s+");
            int x = Integer.parseInt(strs[0]);
            if (x == 0) {
                continue;
            }

            if (p == 0 || x <= xs[p - 1]) {
                xs[p] = x;
                names[p] = strs[1];
                ts[p] = 0;
                p += 1;
            } else {
                ts[p - 1]++;
            }
        }
    }
}
