package codechef.easy.section2.csubseq;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        for (int T = ni(); T > 0; T--) {
            int n = ni(), K = ni();
            char[] s = ns(n);
            int[][][][] dp = new int[K + 2][K + 2][K + 2][K + 2];
            for (int i = 0; i <= K + 1; i++) {
                for (int j = 0; j <= K + 1; j++) {
                    for (int k = 0; k <= K + 1; k++) {
                        Arrays.fill(dp[i][j][k], -99999999);
                    }
                }
            }
            dp[0][0][0][0] = 0;
            for (char c : s) {
                if (c == 'c') {
                    for (int i = K; i >= 0; i--) {
                        for (int j = K + 1; j >= 0; j--) {
                            for (int k = K + 1; k >= 0; k--) {
                                for (int l = K + 1; l >= 0; l--) {
                                    dp[i + 1][j][k][l] = Math.max(dp[i + 1][j][k][l], dp[i][j][k][l] + 1);
                                }
                            }
                        }
                    }
                } else if (c == 'h') {
                    for (int i = K + 1; i >= 0; i--) {
                        for (int j = K + 1; j >= 0; j--) {
                            for (int k = K + 1; k >= 0; k--) {
                                for (int l = K + 1; l >= 0; l--) {
                                    int nj = Math.min(K + 1, j + i);
                                    dp[i][nj][k][l] = Math.max(dp[i][nj][k][l], dp[i][j][k][l] + 1);
                                }
                            }
                        }
                    }
                } else if (c == 'e') {
                    for (int i = K + 1; i >= 0; i--) {
                        for (int j = K + 1; j >= 0; j--) {
                            for (int k = K + 1; k >= 0; k--) {
                                for (int l = K + 1; l >= 0; l--) {
                                    int nk = Math.min(K + 1, k + j);
                                    dp[i][j][nk][l] = Math.max(dp[i][j][nk][l], dp[i][j][k][l] + 1);
                                }
                            }
                        }
                    }
                } else if (c == 'f') {
                    for (int i = K + 1; i >= 0; i--) {
                        for (int j = K + 1; j >= 0; j--) {
                            for (int k = K + 1; k >= 0; k--) {
                                for (int l = K + 1; l >= 0; l--) {
                                    int nl = Math.min(K + 1, l + k);
                                    dp[i][j][k][nl] = Math.max(dp[i][j][k][l], dp[i][j][k][l] + 1);
                                }
                            }
                        }
                    }
                }
            }
            int ans = -1;
            for (int i = 0; i <= K + 1; i++) {
                for (int j = 0; j <= K + 1; j++) {
                    for (int k = 0; k <= K + 1; k++) {
                        ans = Math.max(ans, dp[i][j][k][K]);
                    }
                }
            }
            out.println(ans == -1 ? ans : n - ans);
        }
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty())
            tr(System.currentTimeMillis() - s + "ms");
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++)
            map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private void tr(Object... o) {
        if (INPUT.length() > 0)
            System.out.println(Arrays.deepToString(o));
    }
}
