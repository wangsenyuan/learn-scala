package fun;

public class P3 {

    public static void main(String[] args) {
        //        Scanner scanner = new Scanner(System.in);
        //        int n = scanner.nextInt();
        //        int m = solve(n);
        //        System.out.println(m);
        for (int n = 3; n <= 150; n++) {
            int m = solve(n);
            int m1 = solve1(n);
            System.out.println("n = " + n + " , m = " + m + ", m1 = " + m1);
        }
    }

    private static int solve1(int n) {

        int m = 2;
        while (check(n - 1, m) != 0) {
            m++;
        }
        return m;
    }

    private static int check(int n, int k) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }
        return result;
    }

    private static int solve(int n) {
        boolean[] marked = new boolean[n];

        for (int m = 2; m < 10 * n; m++) {
            if (check(n, m, marked)) {
                return m;
            }
        }
        return -1;
    }

    private static boolean check(int n, int m, boolean[] marked) {
        for (int i = 0; i < n; i++) {
            marked[i] = false;
        }
        marked[0] = true;
        int cnt = n - 1;
        int pos = 0;
        while (cnt > 1 && !marked[1]) {
            int tmp = 0;
            while (tmp < m) {
                if (!marked[pos]) {
                    tmp++;
                    if (tmp == m) {
                        marked[pos] = true;
                        cnt--;
                    }
                }
                pos = (pos + 1) % n;
            }
        }

        return cnt == 1 && !marked[1];
    }
}
