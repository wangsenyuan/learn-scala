package problems.simple.p007;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/21.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        int n = firstLine.length();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char a = firstLine.charAt(i);
            char b = secondLine.charAt(i);
            int c = calc(a - '0', b - '0');
            sb.append(c);
        }

        System.out.println(sb.toString());
    }

    public static int calc(int a, int b) {
        return 1 - (a ^ b);
    }
}
