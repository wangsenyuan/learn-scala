package set0000.set200.set270.p277;

/**
 * Created by senyuanwang on 2016/10/5.
 */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (candidate == i) {
                continue;
            }
            if (knows(candidate, i)) {
                return -1;
            }
            if (!knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCelebrity(2));
    }
}
