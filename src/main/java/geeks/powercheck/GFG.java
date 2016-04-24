package geeks.powercheck;

import java.util.Scanner;

/**
 * Created by wangsenyuan on 4/22/16.
 */
public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (isPower(x, y)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean isPower(int x, int y) {
        if (y == 1 || x == y) {
            return true;
        }

        if (y % x != 0) {
            return false;
        }
        return isPower(x * x, y) || isPower(x * x, y / x);
    }
}
