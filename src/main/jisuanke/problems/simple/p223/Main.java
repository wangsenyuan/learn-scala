package problems.simple.p223;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/4.
 */
public class Main {

    private final Map<Character, Integer> order;

    public Main(String input) {
        order = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            order.put(c, i);
        }
    }

    private int dfs(String str, int i, int[] ds) {
        if(i == str.length()) {
            return 0;
        }
        if(ds[i] > 1) {
            return ds[i];
        }

        int res = 1;

        for(int j = i + 1; j < str.length(); j++) {
            int x = order.get(str.charAt(i));
            int y = order.get(str.charAt(j));
            if(x <= y) {
                res = Math.max(res, dfs(str, j, ds) + 1);
            }
        }
        ds[i] = res;
        return res;
    }

    public int translate(String str) {
        int res = 1;
        int[] ds = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            res = Math.max(res, dfs(str, i, ds));
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();

        Main solution = new Main(firstLine);

        String[] parts = scanner.nextLine().split("\\s+");

        for(String part : parts) {
            System.out.print(solution.translate(part));
        }
    }
}
