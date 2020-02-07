package niuke.p0;

public class Solution {
  public static int NumberOf1Between1AndN_Solution(int n) {
    String s = "" + n;
    int[] P = new int[10];
    P[0] = 1;
    for (int i = 1; i < 10; i++) {
      P[i] = P[i - 1] * 10;
    }
    int m = s.length();
    int[][][] dp = new int[m + 1][10][2];
    dp[0][0][1] = 1;

    int res = 0;

    for (int i = 0; i < m; i++) {
      int x = s.charAt(i) - '0';
      for (int e = 0; e < 2; e++) {
        for (int d = 0; d < 10; d++) {
          for (int dd = 0; dd < 10; dd++) {
            if (e == 1 && dd > x) {
              break;
            }
            int f = 0;
            if (e == 1 && dd == x) {
              f = 1;
            }
            dp[i + 1][dd][f] += dp[i][d][e];
            if (dd == 1) {
              if(f == 1) {
                res += dp[i][d][e] * (n % P[m - 1 - i] + 1);
              } else {
                res += dp[i][d][e] * P[m-1-i];
              }
            }
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(NumberOf1Between1AndN_Solution(1));
    System.out.println(NumberOf1Between1AndN_Solution(13));
  }
}