package problems.simple;

import java.util.Scanner;

/**
 * Created by senyuanwang on 14/11/22.
 */
public class MatrixTransfer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        int t = Integer.parseInt(firstLine[2]);

        int[][] matrix = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        if(t == 0) {
            for(int i = 0; i < m; i++) {
                int[] row = matrix[i];
                for(int j = 0; j < n / 2; j++) {
                    int temp = row[j];
                    row[j] = row[n - 1 - j];
                    row[n - 1 - j] = temp;
                }
            }
        } else {
            for(int j = 0; j < n; j++) {
                for(int i = 0; i < m / 2; i++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[m - 1 - i][j];
                    matrix[m - 1 - i][j] = temp;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            String sep = "";
            for(int j = 0; j < n; j++) {
                System.out.print(sep + matrix[i][j]);
                sep = " ";
            }
            System.out.println();
        }
    }
}
