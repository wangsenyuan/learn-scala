package problems.simple.p133.bubble.sort;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        int[] nums = new int[line.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }

        insertSort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + (i == nums.length - 1 ? "\n" : " "));
        }
    }

    private static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > a) {
                nums[j] = nums[--j];
            }
            nums[j] = a;
        }
    }
}
