package codechef.medium.unique;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void testSample1() {
        String s = "abcab";
        Main main = new Main(s);
        Main.Pair[] res = main.solve();
        Main.Pair[] expect =
            {new Main.Pair(1, 3), new Main.Pair(2, 2), new Main.Pair(3, 1), new Main.Pair(3, 2), new Main.Pair(3, 3)};


        for (int i = 0; i < expect.length; i++) {
            if (expect[i].compareTo(res[i]) != 0) {
                Assert.fail(String.format("expect %s, but got %s", expect[i], res[i]));
            }
        }
    }
}
