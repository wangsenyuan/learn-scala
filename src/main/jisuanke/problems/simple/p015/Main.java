package problems.simple.p015;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/24.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split("\\s+");

        System.out.println(singleNumber(line));
    }

    public static int singleNumber(String[] A) {
        int[] count = new int[32];
        int result = 0;

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                int a = Integer.parseInt(A[j]);
                if (((a >> i) & 1) == 1) {
                    count[i] += 1;
                }
            }

            result |= (count[i] % 3) << i;
        }

        return result;
    }

    public static int singleNumber(int A[], int n) {
        int r = 0, c = 0;
// r A c | r  c
// 0 0 0 | 0  0
// 0 0 1 | 0  1
// 0 1 0 | 1  0  ==> r = (~r & A & ~c) | (r & ~A & ~c)
// 0 1 1 | 0  0  ==> c = (~r & ~A & c) | (r & A & ~c)
// 1 0 0 | 1  0
// 1 0 1 | 0  0
// 1 1 0 | 0  1
// 1 1 1 | 0  0

        while (n > 0) {
            --n;
            int t = (~r & A[n] & ~c) | (r & ~A[n] & ~c);
            c = (~r & ~A[n] & c) | (r & A[n] & ~c);
            r = t;
        }
        return r;
    }
}
