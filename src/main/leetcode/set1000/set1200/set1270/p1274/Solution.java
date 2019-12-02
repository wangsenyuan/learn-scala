package set1000.set1200.set1270.p1274;


// This is Sea's API interface.
// You should not implement it, or speculate about its implementation
interface Sea {
    boolean hasShips(int[] topRight, int[] bottomLeft);
}


public class Solution {

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return count(sea, new int[] {topRight[0], topRight[1]}, bottomLeft);
    }

    private static int count(Sea sea, int[] topRight, int[] bottomLeft) {
        int a = topRight[0];
        int b = topRight[1];
        int c = bottomLeft[0];
        int d = bottomLeft[1];
        // split it into four areas, make them even
        int dx = a - c;
        int dy = b - d;

        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }

        if (dx == 0 && dy == 0) {
            return 1;
        }


        int e = c + dx / 2;
        int f = d + dy / 2;

        if (dy >= 10 * dx) {
            // too narrow
            return count(sea, new int[] {a, f}, bottomLeft) + count(sea, topRight, new int[] {c, f + 1});
        }

        if (dx >= 10 * dy) {
            // too wide
            return count(sea, new int[] {e, b}, bottomLeft) + count(sea, topRight, new int[] {e + 1, d});
        }
        // (e, f) is the middle point
        int x = count(sea, new int[] {e, f}, bottomLeft);
        int y = count(sea, topRight, new int[] {e + 1, f + 1});
        int u = count(sea, new int[] {e, b}, new int[] {c, f + 1});
        int v = count(sea, new int[] {a, f}, new int[] {e + 1, d});

        return x + y + u + v;
    }
}
