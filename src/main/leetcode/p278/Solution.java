package p278;

/**
 * Created by senyuanwang on 15/9/7.
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long i = 1, j = n;

        while (i <= j) {
            int k = (int) ((i + j) / 2);
            boolean bad = isBadVersion(k);
            if (bad) {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }
        return (int)j + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(2126753390));
    }
}
