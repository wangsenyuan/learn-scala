package set1000.set1800.set1850.p1851;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSample1() {
        int[][] ints = new int[][] {{1, 4}, {2, 4}, {3, 6}, {4, 4}};

        int[] queries = new int[] {2, 3, 4, 5};

        int[] expect = new int[] {3, 3, 1, 4};

        int[] res = new Solution().minInterval(ints, queries);

        for (int i = 0; i < res.length; i++) {
            Assert.assertEquals(res[i], expect[i]);
        }
    }

    @Test
    public void testSample2() {
        int[][] ints = new int[][] {{4, 5}, {5, 8}, {1, 9}, {8, 10}, {1, 6}};

        int[] queries = new int[] {7, 9, 3, 9, 3};

        int[] expect = new int[] {4, 3, 6, 3, 6};

        int[] res = new Solution().minInterval(ints, queries);

        for (int i = 0; i < res.length; i++) {
            Assert.assertEquals(res[i], expect[i]);
        }
    }
}
