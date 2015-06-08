package p223.rectangle.area;

/**
 * Created by senyuanwang on 15/6/8.
 */
public class Solution {
    public static int commonArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (E > C && E > A) {
            return 0;
        }

        if (A > G && A > E) {
            return 0;
        }

        if (F > D && F > B) {
            return 0;
        }

        if (B > H && B > F) {
            return 0;
        }

        if (E >= A && F >= B && G <= C && H <= D) {
            return (H - F) * (G - E);
        }

        if (A >= E && B >= F && C <= G && D <= H) {
            return (D - B) * (C - A);
        }

        int X = 0;
        if (A <= E && E <= C) {
            X = E;
        } else {
            X = A;
        }

        int Y = 0;
        if (F <= B && B <= H) {
            Y = B;
        } else {
            Y = F;
        }

        int W = 0;
        if(E <= C && C <= G) {
            W = C;
        } else {
            W = G;
        }

        int Z = 0;
        if(B <= H && H <= D) {
            Z = H;
        } else {
            Z = D;
        }

        return (W - X) * (Z - Y);
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C - A) * (D - B)  + (G - E) * (H - F) - commonArea(A, B, C, D, E, F, G, H);
    }

    public static void main(String[] args) {
        System.out.println(computeArea(0, 0, 0, 0, -1, -1, 1, 1));
    }
}
