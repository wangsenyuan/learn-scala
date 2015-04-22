package problems.simple.p011;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/4/21.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];

        String[] line = scanner.nextLine().split("\\s+");

        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(line[i]);
        }
        int nLen = compact(array);
        System.out.println(nLen);
    }

    public static int compact(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int index = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[index]) {
                continue;
            }

            index = index + 1;
            if(index < i) {
                array[index] = array[i];
            }
        }

        return index + 1;
    }
}
