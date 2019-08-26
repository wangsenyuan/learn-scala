package set0000.set200.set230.p239

import java.util

object Solution {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    val n = nums.length
    if (n == 0) {
      Array()
    } else {
      val res = Array.fill(n - k + 1)(0)

      val tree = new util.TreeMap[Int, Int]()

      def add(num: Int) = {
        if (tree.containsKey(num)) {
          tree.put(num, tree.get(num) + 1)
        } else {
          tree.put(num, 1)
        }
      }

      def remove(num: Int) = {
        val cnt = tree.get(num)
        if (cnt == 1) {
          tree.remove(num)
        } else {
          tree.put(num, cnt - 1)
        }
      }

      var i = 0
      while (i < k) {
        add(nums(i))
        i += 1
      }

      res(0) = tree.lastKey();

      while (i < n) {
        add(nums(i))
        remove(nums(i - k))

        res(i - k + 1) = tree.lastKey()

        i += 1
      }

      res
    }
  }
}
