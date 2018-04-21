package codechef.easy.minsubar;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSample1() {
        int n = 3;
        int d = 6;
        int[] A = {1, 2, 3};
        int expect = 3;
        int res = Main.solve(n, d, A);
        Assert.assertEquals(res, expect);
    }

    @Test
    public void testSample2() {
        int n = 5;
        int d = 5;
        int[] A = {1, 2, 3, 1, -5};
        int expect = 2;
        int res = Main.solve(n, d, A);
        Assert.assertEquals(res, expect);
    }

    @Test
    public void testSample3() {
        int n = 5;
        int d = -5;
        int[] A = {1, 2, 3, 1, -5};
        int expect = 1;
        int res = Main.solve(n, d, A);
        Assert.assertEquals(res, expect);
    }

    @Test
    public void testSample4() {
        int n = 5;
        int d = -4;
        int[] A = {1, 2, 3, 1, -5};
        int expect = 1;
        int res = Main.solve(n, d, A);
        Assert.assertEquals(res, expect);
    }
}
