package codechef.easy.chn01;

import java.io.BufferedInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (BufferedInputStream inputStream = new BufferedInputStream(System.in)) {
            int t = readInt(inputStream);
            for (int i = 0; i < t; i++) {
                int[] nums = readNNums(inputStream, 3);
                System.out.println(solve(nums[0], nums[1], nums[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int e, int m, int h) {
        int left = 0;
        int right = m + 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (check(mid, e, m, h)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static boolean check(int x, int e, int m, int h) {
        return min(e - x, (x + 1) / 2) + min(m - x, (x + 1) / 2) + min(h, (x + 1) / 2) >= x;
    }

    private static int min(int a, int b) {
        if (a <= b) {
            return a;
        }
        return b;
    }

    private static int[] readNNums(BufferedInputStream inputStream, int n) throws IOException {
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp = 0;
            while (true) {
                int letter = inputStream.read();
                if (letter < 0 || letter == '\n' || letter == ' ') {
                    break;
                }
                tmp = tmp * 10 + letter - '0';
            }
            res[i] = tmp;
        }

        return res;
    }

    private static int readInt(BufferedInputStream inputStream) throws IOException {
        int res = 0;

        while (true) {
            int letter = inputStream.read();
            if (letter == '\n' || letter < 0) {
                break;
            }
            res = res * 10 + letter - '0';
        }

        return res;
    }
}

