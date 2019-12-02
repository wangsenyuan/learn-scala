package set1000.set1200.set1270.p1274;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    class TestSea implements Sea {
        private final int[][] ships;

        TestSea(int[][] ships) {
            this.ships = ships;
        }

        @Override
        public boolean hasShips(int[] topRight, int[] bottomLeft) {
            int a = topRight[0];
            int b = topRight[1];
            int c = bottomLeft[0];
            int d = bottomLeft[1];
            for (int[] ship : ships) {
                int x = ship[0];
                int y = ship[1];
                if (c <= x && x <= a && d <= y && y <= b) {
                    return true;
                }
            }

            return false;
        }
    }

    @Test
    public void testSample1() {
        int[] topRight = {4, 4};
        int[] bottomLeft = {0, 0};
        TestSea sea = new TestSea(new int[][] {{1, 1}, {2, 2}, {3, 3}});
        int res = new Solution().countShips(sea, topRight, bottomLeft);
        Assert.assertEquals(3, res);
    }

    @Test
    public void testSample2() {
        int[] topRight = {1000, 1000};
        int[] bottomLeft = {0, 0};
        TestSea sea = new TestSea(new int[][] {{6, 6}, {100, 50}, {999, 81}, {50, 50}, {700, 600}});
        int res = new Solution().countShips(sea, topRight, bottomLeft);
        Assert.assertEquals(5, res);
    }
}
