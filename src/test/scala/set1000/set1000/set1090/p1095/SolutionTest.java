package set1000.set1000.set1090.p1095;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testSample1() {
        int[] arr = {0, 5, 3, 1};
        int target = 1;
        MountainArray array = new MountainArray() {
            @Override
            public int get(int index) {
                return arr[index];
            }

            @Override
            public int length() {
                return arr.length;
            }
        };

        int res = new Solution().findInMountainArray(target, array);
        Assert.assertEquals(3, res);
    }
}
