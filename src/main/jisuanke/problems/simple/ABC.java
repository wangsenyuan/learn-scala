package problems.simple;

import java.util.Scanner;

/**
 * Created by senyuanwang on 14/11/20.
 */


public class ABC {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String line = cin.nextLine();
        String[] abc = line.split("\\s+");
        int a = Integer.parseInt(abc[0]);
        int b = Integer.parseInt(abc[1]);
        int c = Integer.parseInt(abc[2]);
        System.out.println(a + b + c);
    }
}