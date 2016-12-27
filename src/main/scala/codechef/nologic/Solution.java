package codechef.nologic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wangsenyuan on 27/12/2016.
 */
public class Solution {
    public static void main(String[] args) {

        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        try (Scanner scanner = new Scanner(System.in)) {
            int t = Integer.parseInt(scanner.nextLine());
            StringBuilder sb = new StringBuilder();

            while (t > 0) {
                t--;
                String line = scanner.nextLine();
                Set<Character> cs = new HashSet<>();
                for (Character c : line.toLowerCase().toCharArray()) {
                    cs.add(c);
                }
                sb.setLength(0);
                for (Character c : letters) {
                    if (cs.contains(c)) {
                        continue;
                    }
                    sb.append(c);
                }

                if (sb.length() == 0) {
                    System.out.println("~");
                } else {
                    System.out.println(sb.toString());
                }
            }
        }
    }
}
