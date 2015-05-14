package problems.simple.p024;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/14.
 */
public class Main {
    static Map<Character, Integer> map = new HashMap<Character, Integer>();
    static {
        map.put('0', 1);
        map.put('1', 0);
        map.put('2', 0);
        map.put('3', 0);
        map.put('4', 0);
        map.put('5', 0);
        map.put('6', 1);
        map.put('7', 0);
        map.put('8', 2);
        map.put('9', 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        long sum = 0;
        for(int i = 0; i < line.length(); i++) {
            sum += map.get(line.charAt(i));
        }
        System.out.println(sum);
    }
}
