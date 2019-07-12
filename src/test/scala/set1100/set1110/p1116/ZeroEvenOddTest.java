package set1100.set1110.p1116;

import org.junit.Test;

import java.util.function.IntConsumer;

public class ZeroEvenOddTest {

    @Test
    public void testSample1() throws InterruptedException {
        ZeroEvenOdd target = new ZeroEvenOdd(10);
        IntConsumer fn = (x) -> System.out.print(x);
        Thread a = new Thread(() -> {
            try {
                target.zero(fn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread b = new Thread(() -> {
            try {
                target.odd(fn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread c = new Thread(() -> {
            try {
                target.even(fn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        a.start();
        b.start();
        c.start();

        Thread.sleep(3000);
    }
}
