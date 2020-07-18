package set1000.set1400.set1490.p1495;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSample1() {
        String s = "NES";
        Solution solution = new Solution();
        boolean res = solution.isPathCrossing(s);
        Assert.assertFalse(res);
    }

    @Test
    public void testSample2() {
        String s = "NESWW";
        Solution solution = new Solution();
        boolean res = solution.isPathCrossing(s);
        Assert.assertTrue(res);
    }

    @Test
    public void testSample3() {
        String s = "SN";
        Solution solution = new Solution();
        boolean res = solution.isPathCrossing(s);
        Assert.assertTrue(res);
    }


    @Test
    public void testSample4() {
        String s = "SS";
        Solution solution = new Solution();
        boolean res = solution.isPathCrossing(s);
        Assert.assertFalse(res);
    }
}
