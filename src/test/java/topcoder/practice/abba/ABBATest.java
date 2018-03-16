package topcoder.practice.abba;

import org.junit.Test;
import org.testng.Assert;

public class ABBATest {

    @Test
    public void testSample1() {
        ABBA ABBA = new ABBA();
        String src = "B";
        String dst = "ABBA";
        String res = ABBA.canObtain(src, dst);
        Assert.assertEquals(res, "Possible");
    }

    @Test
    public void testSample2() {
        ABBA ABBA = new ABBA();
        String src = "AB";
        String dst = "ABB";
        String res = ABBA.canObtain(src, dst);
        Assert.assertEquals(res, "Impossible");
    }

    @Test
    public void testSample3() {
        ABBA ABBA = new ABBA();
        String src = "BBAB";
        String dst = "ABABABABB";
        String res = ABBA.canObtain(src, dst);
        Assert.assertEquals(res, "Impossible");
    }

    @Test
    public void testSample4() {
        ABBA ABBA = new ABBA();
        String src = "BBBBABABBBBBBA";
        String dst = "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA";
        String res = ABBA.canObtain(src, dst);
        Assert.assertEquals(res, "Possible");
    }

    @Test
    public void testSample5() {
        ABBA ABBA = new ABBA();
        String src = "A";
        String dst = "BB";
        String res = ABBA.canObtain(src, dst);
        Assert.assertEquals(res, "Impossible");
    }
}
