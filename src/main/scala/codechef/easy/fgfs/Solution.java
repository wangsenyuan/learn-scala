package codechef.easy.fgfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangsenyuan on 16/02/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            List<Customer>[] as = new List[k];

            while (n-- > 0) {
                int s = scanner.nextInt();
                int x = scanner.nextInt();
                int p = scanner.nextInt() - 1;
                if (as[p] == null) {
                    as[p] = new ArrayList<>();
                }

                as[p].add(new Customer(s, x, p));
            }

            long res = 0;

            for (List<Customer> customers : as) {
                if (customers == null) {
                    continue;
                }
                res += serve(customers);
            }
            System.out.println(res);
        }
    }

    private static long serve(List<Customer> customers) {
        Collections.sort(customers, (a, b) -> {
            if (a.t < b.t) {
                return -1;
            } else if (a.t > b.t) {
                return 1;
            }
            return 0;
        });

        int cnt = 1;
        int cur = customers.get(0).t;
        for (int i = 1; i < customers.size(); i++) {
            if (customers.get(i).s >= cur) {
                cnt++;
                cur = customers.get(i).t;
            }
        }

        return cnt;
    }

    static class Customer {
        final int s, t, p;

        Customer(int s, int t, int p) {
            this.s = s;
            this.t = t;
            this.p = p;
        }
    }
}
