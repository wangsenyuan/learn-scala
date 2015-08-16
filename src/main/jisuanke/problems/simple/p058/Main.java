package problems.simple.p058;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/8/13.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().toLowerCase();

        boolean result = isPalindrome(line.toCharArray());
        System.out.println(result);
    }

    public static boolean isPalindrome(char[] cs) {
        if (cs.length == 0) {
            return true;
        }
        int i = 0, j = cs.length - 1;

        for (; i < j; ) {
            if (!isWord(cs[i])) {
                i += 1;
                continue;
            }

            if (!isWord(cs[j])) {
                j -= 1;
                continue;
            }

            if (cs[i] != cs[j]) {
                break;
            }
            i += 1;
            j -= 1;
        }
        return i >= j;
    }

    private static boolean isWord(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
