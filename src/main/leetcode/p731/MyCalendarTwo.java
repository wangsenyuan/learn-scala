package p731;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarTwo {
    private class Calendar {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public boolean book(int start, int end) {
            Integer p = map.lowerKey(start);

            if (p != null && map.get(p) > start) {
                return false;
            }

            Integer q = map.lowerKey(end);
            if (q != null && q >= start) {
                return false;
            }
            map.put(start, end);
            return true;
        }
    }


    private List<int[]> list = new ArrayList<>();

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        Calendar calendar = new Calendar();
        for (int[] pair : list) {
            int a = pair[0];
            int b = pair[1];
            if (a < start && b > start) {
                if (!calendar.book(start, b)) {
                    return false;
                }
            } else if (a >= start && a < end) {
                if (!calendar.book(a, Math.min(end, b))) {
                    return false;
                }
            }
        }

        list.add(new int[] {start, end});
        return true;
    }


    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test2() {
        int[][] bookings =
            new int[][] {{47, 50}, {1, 10}, {27, 36}, {40, 47}, {20, 27}, {15, 23}, {10, 18}, {27, 36}, {17, 25},
                {8, 17}, {24, 33}, {23, 28}, {21, 27}, {47, 50}, {14, 21}, {26, 32}, {16, 21}, {2, 7}, {24, 33},
                {6, 13}, {44, 50}, {33, 39}, {30, 36}, {6, 15}, {21, 27}, {49, 50}, {38, 45}, {4, 12}, {46, 50},
                {13, 21}};
        boolean[] result =
            {true, true, true, true, true, true, true, true, false, false, false, false, false, true, false, false,
                false, true, false, false, false, false, false, false, false, false, true, false, false, false};
        execute(bookings, result);
    }

    private static void execute(int[][] bookings, boolean[] result) {
        MyCalendarTwo calendar = new MyCalendarTwo();
        for (int i = 0; i < bookings.length; i++) {
            int a = bookings[i][0];
            int b = bookings[i][1];
            boolean res = calendar.book(a, b);
            if (res != result[i]) {
                System.err.printf("get wrong answer when book %d - %d, expect %b, but get %b\n", a, b, result[i], res);
                System.exit(1);
            }
        }
        System.out.println("pass the sample");
    }

    private static void test3() {
        int[][] bookings =
            new int[][] {{24, 40}, {43, 50}, {27, 43}, {5, 21}, {30, 40}, {14, 29}, {3, 19}, {3, 14}, {25, 39},
                {6, 19}};
        boolean[] result = {true, true, true, true, false, false, true, false, false, false};
        execute(bookings, result);
    }

    private static void test1() {
        MyCalendarTwo calendar = new MyCalendarTwo();
        if (!calendar.book(10, 20)) {
            System.err.println("should be able to book 10 - 20");
            System.exit(1);
        }

        if (!calendar.book(50, 60)) {
            System.err.println("should be able to book 50 - 60");
            System.exit(1);
        }

        if (!calendar.book(10, 40)) {
            System.err.println("should be able to book 10 - 40");
            System.exit(1);
        }

        if (calendar.book(5, 15)) {
            System.err.println("should not be able to book 5 - 15");
            System.exit(1);
        }

        if (!calendar.book(5, 10)) {
            System.err.println("should be able to book 5 - 10");
            System.exit(1);
        }

        if (!calendar.book(25, 55)) {
            System.err.println("should be able to book 25 - 55");
            System.exit(1);
        }

        System.out.println("pass the sample");
    }
}
