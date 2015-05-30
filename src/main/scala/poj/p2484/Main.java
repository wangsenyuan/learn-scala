package poj.p2484;

import java.util.Scanner;

/**
 * Created by senyuanwang on 15/5/29.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n <= 2) {
            System.out.println("Alice");
        } else {
            System.out.println("Bob");
        }
    }
}
