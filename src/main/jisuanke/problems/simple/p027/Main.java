package problems.simple.p027;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/21.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(scanner.nextLine().trim());
            if (array[i] == 1) {
                oneCount += 1;
            } else if (array[i] == 2) {
                twoCount += 1;
            } else if (array[i] == 3) {
                threeCount += 1;
            }
        }

        int reverseCount = 0;
        for (int i = 0; i < oneCount; i++) {
            if (array[i] == 1) {
                continue;
            }

            reverseCount += 1;
            if (array[i] == 2) {
                swapBetween(array, i, 1, oneCount, oneCount + twoCount);
            } else if (array[i] == 3) {
                swapBetween(array, i, 1, oneCount + twoCount, n);
            }
        }

        for (int i = oneCount; i < oneCount + twoCount; i++) {
            if (array[i] == 2) {
                continue;
            }

            reverseCount += 1;

            if (array[i] == 3) {
                swapBetween(array, i, 2, oneCount + twoCount, n);
            }
        }
        System.out.println(reverseCount);
    }

    public static void swapBetween(int[] array, int i, int x, int start, int end) {
        for (int j = start; j < end; j++) {
            if (array[j] == x) {
                array[j] = array[i];
                array[i] = x;
                return;
            }
        }
    }
}
