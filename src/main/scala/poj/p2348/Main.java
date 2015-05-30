package poj.p2348;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/29.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == 0 && b == 0) {
                break;
            }
            if (play(a, b)) {
                System.out.println("Stan wins");
            } else {
                System.out.println("Ollie wins");
            }
        } while (true);
    }

    public static boolean play(int a, int b) {
        if (a > b) {
            return play(b, a);
        }

        boolean win = true;
        for (; ; ) {
            if (b % a == 0 || b - a > a) {
                break;
            }
            b -= a;
            win = !win;
        }
        return win;
    }
}
