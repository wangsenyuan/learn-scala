package problems.simple.p023;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/14.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            process(scanner.nextInt());
        }
    }

    private static void process(int n) {
        StringBuilder[] xs = new StringBuilder[2];
        xs[0] = new StringBuilder("1");
        xs[1] = new StringBuilder();
        int index = 0;

        int i = 1;
        while (i < n) {
            int nxt = (index + 1) % 2;
            StringBuilder current = xs[index];
            StringBuilder next = xs[nxt];
            next.setLength(0);
            for (int j = 0, k = 0; j < current.length(); ) {
                char x = current.charAt(k);
                while(k < current.length() && current.charAt(k) == x) {
                    k++;
                }
                int count = k - j;
                next.append(count).append(x);
                j = k;
            }

            index = nxt;
            i++;
        }
        System.out.println(xs[index].toString());
    }
}
