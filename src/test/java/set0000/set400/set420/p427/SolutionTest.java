package set0000.set400.set420.p427;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testSample1() {
        int[][] grid =
            {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}};
        Solution solution = new Solution();
        Node root = solution.construct(grid);
        Assert.assertFalse(root.isLeaf);
        Assert.assertNotNull(root.topLeft);
        Assert.assertTrue(root.topLeft.isLeaf);
        Assert.assertTrue(root.topLeft.val);
    }
}
