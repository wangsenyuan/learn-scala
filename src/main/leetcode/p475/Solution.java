package p475;

import java.util.Arrays;

/**
 * Created by senyuanwang on 2016/12/11.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        System.out.println(solution.findRadius(houses, heaters));
    }

    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0)
            return 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1 && heaters[j] < houses[i]) { // then find a heater that stands after the house
                j++;
            }
            if (heaters[j] < houses[i]) { // corner cases if j is 0 or there is no more heaters
                ans = Math.max(ans, houses[i] - heaters[j]);
            } else {
                int dist = heaters[j] - houses[i];
                if (j > 0) {
                    dist = Math.min(dist, houses[i] - heaters[j - 1]);
                }
                ans = Math.max(ans, dist);
            }

            i++;
        }

        return ans;
    }
}
