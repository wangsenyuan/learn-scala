package set1100.set1110.p1117;

import java.util.concurrent.Semaphore;

public class H2O {
    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(1);
    private Semaphore w = new Semaphore(3);

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        ;
        w.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();

        releaseSemaphore();
    }

    private void releaseSemaphore() {
        if (w.availablePermits() == 0) {
            o.release(1);
            h.release(2);
            w.release(3);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        w.acquire();

        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();

        releaseSemaphore();
    }



}
