package problems.simple.p014;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/10.
 */
public class Main {
    private static Map<Character, Integer> map = new HashMap<Character, Integer>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static int process(char[] cs, int index, int result) {
        if (index == cs.length) {
            return result;
        }

        if (index == cs.length - 1) {
            return result + map.get(cs[index]);
        } else {
            char c = cs[index];
            char nc = cs[index + 1];
            if (map.get(c) < map.get(nc)) {
                return process(cs, index + 2, result + map.get(nc) - map.get(c));
            } else {
                return process(cs, index + 1, result + map.get(c));
            }
        }
    }

    public static int romanToInt(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        return process(s.toCharArray(), 0, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(romanToInt(scanner.nextLine()));
    }
}
