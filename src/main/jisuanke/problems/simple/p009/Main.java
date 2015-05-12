package problems.simple.p009;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/24.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] line = scanner.nextLine().split("\\s+");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        int x = Integer.parseInt(scanner.nextLine());

        int nlen = removeElement(nums, n, x);
        System.out.println(nlen);
    }

    public static int removeElement(int[] nums, int n, int elem) {

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == elem) {
                continue;
            }
            nums[++index] = nums[i];
        }

        return index + 1;
    }
}
