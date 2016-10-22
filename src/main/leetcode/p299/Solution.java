package p299;

/**
 * Created by senyuanwang on 15/10/31.
 */
public class Solution {

    public String getHint(String secret, String guess) {
        char[] as = secret.toCharArray();
        char[] bs = guess.toCharArray();

        int a = 0;
        int b = 0;
        int[] nums = new int[10];

//        Arrays.fill(nums, -1);

        for (int i = 0; i < as.length; i++) {
            int x = as[i] - '0';
            nums[x] += 1;
        }

        for (int i = 0; i < as.length; i++) {
            int x = bs[i] - '0';
            if (as[i] == bs[i]) {
                a += 1;
                nums[x] -= 1;
                continue;
            }
        }


        for (int i = 0; i < as.length; i++) {
            int x = bs[i] - '0';
            if (as[i] != bs[i] && nums[x] > 0) {
                b += 1;
                nums[x] -= 1;
            }
        }

        return a + "A" + b + "B";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String secret = "11";
        String guess = "10";
        System.out.println(solution.getHint(secret, guess));
    }
}
