package set1000.set1100.set1190.p1195;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    //    private AtomicInteger seq;
    private volatile int seq;

    public FizzBuzz(int n) {
        this.n = n;
        //        this.seq = new AtomicInteger(1);
        this.seq = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (seq <= n) {
            if (isCaseTwo(seq) && seq <= n) {
                printFizz.run();
                seq++;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (seq <= n) {
            if (isCaseThree(seq) && seq <= n) {
                printBuzz.run();
                seq++;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (seq <= n) {
            if (isCaseFour(seq) && seq <= n) {
                printFizzBuzz.run();
                seq++;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (seq <= n) {
            if (isCaseOne(seq) && seq <= n) {
                printNumber.accept(seq++);
            }
        }
    }


    private boolean isCaseOne(int x) {
        if (x % 3 == 0) {
            return false;
        }
        if (x % 5 == 0) {
            return false;
        }
        return true;
    }

    private boolean isCaseTwo(int x) {
        if (x % 5 == 0) {
            return false;
        }
        return x % 3 == 0;
    }

    private boolean isCaseThree(int x) {
        if (x % 3 == 0) {
            return false;
        }
        return x % 5 == 0;
    }

    private boolean isCaseFour(int x) {
        return x % 3 == 0 && x % 5 == 0;
    }
}
