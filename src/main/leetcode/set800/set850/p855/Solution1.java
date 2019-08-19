package set800.set850.p855;

import java.util.TreeSet;

public class Solution1 {


    class ExamRoom {
        private int N;
        private TreeSet<Integer> seats;

        public ExamRoom(int N) {
            this.N = N;
            this.seats = new TreeSet<>();
        }

        public int seat() {
            int cur = 0;
            if (seats.size() > 0) {
                int dist = seats.first();
                Integer prev = null;
                for (Integer seat : seats) {
                    if (prev != null) {
                        int d = (seat - prev) / 2;
                        if (d > dist) {
                            dist = d;
                            cur = prev + d;
                        }
                    }
                    prev = seat;
                }

                if (N - 1 - seats.last() > dist) {
                    cur = N - 1;
                }
            }

            seats.add(cur);

            return cur;

        }

        public void leave(int p) {
            seats.remove(p);
        }
    }



}

