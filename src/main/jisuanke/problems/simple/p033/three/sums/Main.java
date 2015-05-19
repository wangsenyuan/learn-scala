package problems.simple.p033.three.sums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by senyuanwang on 15/5/19.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int c = -(nums[i] + nums[j]);
                int k = Arrays.binarySearch(nums, j + 1, nums.length, c);
                if (k > j) {
                    String str = nums[i] + " " + nums[j] + " " + nums[k];
                    if(set.contains(str)) {
                       continue;
                    }
                    set.add(str);
                    System.out.println(str);
                }
            }
        }
    }
}
