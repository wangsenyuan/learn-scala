package set0000.set400.set440.p440;

/**
 * Created by senyuanwang on 2016/10/23.
 */
public class Solution1 {

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();

        System.out.println(solution1.findKthNumber(13, 6));

        System.out.println(solution1.findKthNumber(681692778, 351251360));
    }

    int index = 0;
    int ans = 0;

    public int findKthNumber(int n, int k) {
        for (int i = 1; i <= 9; i++) {
            int c = count(n, i, "");
            if (k > c + index) {
                index += c;
                continue;
            }
            if (helper(n, k, "" + i)) break;
        }
        return ans;
    }

    public boolean helper(int n, int k, String cur) {
        index++;
        if (index == k) {
            ans = Integer.valueOf(cur);
            return true;
        }
        for (int i = 0; i <= 9; i++) {
            int c = count(n, i, cur);
            if (k > c + index) {
                index += c;
                continue;
            }
            if (Integer.valueOf(cur + i) <= n) if (helper(n, k, cur + i)) return true;
        }
        return false;
    }

    public int count(int n, int i, String prefix) {
        long cur = Long.valueOf(prefix + i);
        int ans = 0;
        int number = 1;
        while (cur <= n) {
            ans += number;
            cur *= 10;
            number *= 10;
        }
        if (n < (cur / 10 + number / 10 - 1)) ans -= cur / 10 + number / 10 - 1 - n;
        return ans;
    }
}
