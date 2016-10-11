package p295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wangsenyuan on 11/10/2016.
 */
public class MedianFinder2 {

    private PriorityQueue<Integer> gt = new PriorityQueue<>();
    private PriorityQueue<Integer> lt = new PriorityQueue<>(Comparator.reverseOrder());
    private double median = 0.0;

    // Adds gt number into the data structure.
    public void addNum(int num) {
        if (num <= median) {
            lt.add(num);
        } else {
            gt.add(num);
        }

        if (gt.size() > lt.size()) {
            lt.add(gt.poll());
        } else if (gt.size() < lt.size()) {
            gt.add(lt.poll());
        }

        if (gt.size() == lt.size()) {
            median = (gt.peek() + lt.peek()) / 2.0;
        } else if (gt.size() > lt.size()) {
            median = gt.peek();
        } else {
            median = lt.peek();
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return median;
    }

    public static void main(String[] args) {
        MedianFinder2 medianFinder = new MedianFinder2();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }
}
