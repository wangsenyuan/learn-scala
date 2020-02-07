package niuke.p1;

import java.util.*;

public class Solution {
  public static int GetUglyNumber_Solution(int index) {
    if (index == 0) {
      return 0;
    }
    if (index == 1) {
      return 1;
    }
    if (index == 2) {
      return 2;
    }
    if (index == 3) {
      return 3;
    }

    TreeSet<Long> set = new TreeSet<>();

    set.add(2L);
    set.add(3L);
    set.add(5L);

    int i = 2;

    while (i < index) {
      long x = set.first();
      set.remove(x);
      set.add(x * 2);
      set.add(x * 3);
      set.add(x * 5);
      i++;
    }

    return set.first().intValue();
  }

  public static void main(String[] args) {
    for (int i = 1; i <= 20; i++) {
      System.out.println(GetUglyNumber_Solution(i));
    }
  }
}