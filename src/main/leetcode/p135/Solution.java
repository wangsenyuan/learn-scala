package p135;

/**
 * Created by wangsenyuan on 8/20/16.
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int total = 1, prev = 1, countDown = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (countDown > 0) {
                    total += countDown * (countDown + 1) / 2; // arithmetic progression
                    if (countDown >= prev) {
                        total += countDown - prev + 1;
                    }
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                total += prev;
            } else {
                countDown++;
            }
        }
        if (countDown > 0) { // if we were descending at the end
            total += countDown * (countDown + 1) / 2;
            if (countDown >= prev) {
                total += countDown - prev + 1;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //        int[] ratings = {4, 2, 3, 4, 1};
        //int[] ratings = {2, 3, 2};
        //int[] ratings = {1, 2, 4, 4, 3};
        int[] ratings = {1, 3, 4, 3, 2, 1};
        System.out.println(solution.candy(ratings));
    }
}
