package set300.set310.p318;

/**
 * Created by wangsenyuan on 03/11/2016.
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(maxProduct(new String[] {"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(maxProduct(new String[] {"a", "aa", "aaa", "aaaa"}));
    }

    public static int maxProduct(String[] words) {
        int n = words.length;
        if (n == 0) {
            return 0;
        }

        int[] xs = new int[n];

        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = 0; j < words[i].length(); j++) {
                int y = words[i].charAt(j) - 'a';
                x |= 1 << y;
            }
            xs[i] = x;
        }

        int maxProd = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((xs[i] & xs[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    if (prod > maxProd) {
                        maxProd = prod;
                    }
                }
            }
        }
        return maxProd;
    }
}
