package p474;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by senyuanwang on 2016/12/11.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] strs = {"10", "0001", "111001", "1", "0"};
//        String[] strs = {"10", "0001", "111001", "1", "0"};
        String[] strs = {"10", "0", "1"};
        int m = 1;
        int n = 1;
        System.out.println(solution.findMaxForm(strs, m, n));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        Item[] items = new Item[strs.length];
        for (int i = 0; i < strs.length; i++) {
            int a = 0;
            int b = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if ('0' == strs[i].charAt(j)) {
                    a++;
                } else {
                    b++;
                }
            }
            items[i] = new Item(a, b);
        }

        Arrays.sort(items, Comparator.comparing(Item::getA));

        PriorityQueue<Item> pq = new PriorityQueue<>((Item x, Item y) -> {
            if (x.b > y.b) {
                return -1;
            } else if (x.b < y.b) {
                return 1;
            } else if (x.a > y.a) {
                return -1;
            } else if (x.a < y.a) {
                return 1;
            } else {
                return 0;
            }
        });

        int a = 0;
        int b = 0;
        int ans = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].a + a > m) {
                break;
            }
            pq.offer(items[i]);
            a += items[i].a;
            b += items[i].b;
            ans++;
            while (b > n && pq.size() > 0) {
                Item pop = pq.poll();
                a -= pop.a;
                b -= pop.b;
                ans--;
            }
        }
        return ans;
    }

    static class Item {
        final int a;
        final int b;

        public Item(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
