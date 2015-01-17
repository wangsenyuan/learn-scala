package problems.simple;

import java.util.Scanner;

/**
 * Created by senyuanwang on 14/11/24.
 */
public class StealClay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        while(i > 0) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            String minName = null;
            String maxName = null;
            for(int j = 0; j < i; j++) {
                String[] line = scanner.nextLine().split("\\s+");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                int c = Integer.parseInt(line[2]);
                int size = a * b * c;
                if(size > max) {
                    max = size;
                    maxName = line[3];
                }
                if(size < min) {
                    min = size;
                    minName = line[3];
                }
            }

            System.out.println(maxName + " took clay from " + minName + ".");
            i = Integer.parseInt(scanner.nextLine());
        }
    }
}
