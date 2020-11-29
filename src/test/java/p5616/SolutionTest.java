package p5616;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSample1() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int res = solution.minimumDeviation(nums);
        Assert.assertEquals(res, 1);
    }

    @Test
    public void testSample2() {
        Solution solution = new Solution();
        int[] nums = {4, 1, 5, 20, 3};
        int res = solution.minimumDeviation(nums);
        Assert.assertEquals(res, 3);
    }

    @Test
    public void testSample3() {
        Solution solution = new Solution();
        int[] nums = {2, 10, 8};
        int res = solution.minimumDeviation(nums);
        Assert.assertEquals(res, 3);
    }

    @Test
    public void testSample4() {
        Solution solution = new Solution();
        int[] nums = {900, 241, 842, 374, 758, 39, 687, 242, 912};
        int res = solution.minimumDeviation(nums);
        Assert.assertEquals(res, 609);
    }

    @Test
    public void testSample5() {
        Solution solution = new Solution();
        int[] nums = {136, 465, 87};
        int res = solution.minimumDeviation(nums);
        Assert.assertEquals(329, res);
    }
}
