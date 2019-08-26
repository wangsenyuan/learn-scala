package set1000.set1100.set1110.p1116;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    Lock lock;
    Condition zero, one, two;
    private AtomicInteger x = new AtomicInteger(0);
    private AtomicBoolean z = new AtomicBoolean(true);
    public ZeroEvenOdd(int n) {
        this.n = n;
        lock = new ReentrantLock();
        zero = lock.newCondition();
        one = lock.newCondition();
        two = lock.newCondition();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();

            while(!z.get()) {
                zero.await();
            }
            z.set(false);

            printNumber.accept(0);
            int y = x.incrementAndGet();

            if(y % 2 == 1) {
                one.signal();
            } else {
                two.signal();
            }

            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int y = 1;
        while (y <= n) {
            lock.lock();

            while (x.get() < y) {
                one.await();
            }
            printNumber.accept(y);
            y += 2;

            z.set(true);
            zero.signal();

            lock.unlock();

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int y = 2;
        while (y <= n) {
            lock.lock();

            while (x.get() < y) {
                two.await();
            }
            printNumber.accept(y);
            y += 2;

            z.set(true);
            zero.signal();
            lock.unlock();
        }
    }
}
