package codechef.easy.distcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wangsenyuan on 28/02/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            String s = scanner.next();

            Set<String> codes = new HashSet<>();

            for (int i = 0; i < s.length() - 1; i++) {
                codes.add("" + s.charAt(i) + s.charAt(i + 1));
            }

            System.out.println(codes.size());
        }

    }
}
