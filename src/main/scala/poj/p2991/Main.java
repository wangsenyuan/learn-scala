package poj.p2991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by senyuanwang on 15/4/21.
 */
public class Main {
    static int ST_SIZE = (1 << 15) - 1;
    private static double[] vx = new double[ST_SIZE];
    private static double[] vy = new double[ST_SIZE];
    private static double[] ang = new double[ST_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            processOneCase(br);
            if (br.readLine() == null) {
                break;
            }
            System.out.println();
        } while (true);
    }

    private static void processOneCase(BufferedReader scanner) throws IOException {
        String[] firstLine = scanner.readLine().split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int c = Integer.parseInt(firstLine[1]);
        String[] lxs = scanner.readLine().split("\\s+");
        int[] ls = new int[lxs.length];
        for (int i = 0; i < ls.length; i++) {
            ls[i] = Integer.parseInt(lxs[i]);
        }

        RMQ rmq = new RMQ(vx, vy, ang, n, ls);

        double[] prv = new double[n];

        for (int i = 1; i < n; i++) {
            prv[i] = Math.PI;
        }

        for (int i = 0; i < c; i++) {
            String[] line = scanner.readLine().split("\\s+");
            int s = Integer.parseInt(line[0]);
            int ang = Integer.parseInt(line[1]);
            double a = ang / 360.0 * 2 * Math.PI;

            rmq.change(s, a - prv[s]);
            prv[s] = a;

            System.out.println(String.format("%.2f %.2f", rmq.endX(), rmq.endY()));
        }
    }

    static class RMQ {
        private final double[] vx;
        private final double[] vy;
        private final double[] ang;
        private final int[] ls;
        private final int n;

        public RMQ(double[] vx, double[] vy, double[] ang, int n, int[] ls) {
            this.vx = vx;
            this.vy = vy;
            this.ang = ang;
            this.ls = ls;
            this.n = n;
//            this.vx = new double[n * 2 + 1];
//            this.vy = new double[n * 2 + 1];
//            this.ang = new double[n * 2 + 1];
//            Arrays.fill(vx, 0);
//            Arrays.fill(ang, 0);
            init(0, 0, n);
        }

        private void init(int k, int l, int r) {
            ang[k] = vx[k] = 0.0;

            if (r - l == 1) {
                vy[k] = ls[l];
            } else {
                int chl = k * 2 + 1, chr = k * 2 + 2;
                init(chl, l, (l + r) / 2);
                init(chr, (l + r) / 2, r);
                vy[k] = vy[chl] + vy[chr];
            }
        }

        private void change(int s, double a, int v, int l, int r) {
            if (s <= l || s >= r) {
                return;
            }

            int chl = v * 2 + 1, chr = v * 2 + 2;
            int m = (l + r) / 2;
            change(s, a, chl, l, m);
            change(s, a, chr, m, r);

            if (s <= m) {
                ang[v] += a;
            }

            double xs = Math.sin(ang[v]), xc = Math.cos(ang[v]);
            vx[v] = vx[chl] + (xc * vx[chr] - xs * vy[chr]);
            vy[v] = vy[chl] + (xs * vx[chr] + xc * vy[chr]);
        }

        public void change(int s, double a) {
            change(s, a, 0, 0, n);
        }

        public double endX() {
            return vx[0];
        }

        public double endY() {
            return vy[0];
        }
    }
}
