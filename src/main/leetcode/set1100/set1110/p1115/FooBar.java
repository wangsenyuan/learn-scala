package set1100.set1110.p1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {
    private int n;

    private Lock lock;
    private Condition a, b;
    private volatile int x = 0;
    public FooBar(int n) {
        this.n = n;
        lock = new ReentrantLock();
        a = lock.newCondition();
        b = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();

            while(x % 2 != 0) {
                a.await();
            }

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();

            x++;
            b.signal();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();
            while(x % 2 != 1) {
                b.await();
            }

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            x++;
            a.signal();
            lock.unlock();
        }
    }
}
