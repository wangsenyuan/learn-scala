package set1100.set1110.p1114;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    Lock lock;
    Condition a, b, c;
    AtomicInteger x = new AtomicInteger(0);
    public Foo() {
        lock = new ReentrantLock();
        a = lock.newCondition();
        b = lock.newCondition();
        c = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        while(x.get() % 3 != 0) {
            a.await();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        x.incrementAndGet();
        b.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        while(x.get() % 3 != 1) {
            b.await();
        }
        printSecond.run();
        x.incrementAndGet();
        c.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        while(x.get() % 3 != 2) {
            c.await();
        }
        printThird.run();
        x.incrementAndGet();
        a.signal();
        lock.unlock();
    }
}
