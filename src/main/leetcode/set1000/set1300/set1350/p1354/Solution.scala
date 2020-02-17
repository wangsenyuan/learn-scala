package set1000.set1300.set1350.p1354

import scala.util.Sorting

object Solution {
  def isPossible(target: Array[Int]): Boolean = {
    val n = target.length
    if (n == 1) {
      target(0) == 1
    } else {
      // 1...x...1 => n - 1 + n = x
      // s(0) = n, s(1) = 2 * n - 1, s(2) = 1...n... 2 * n - 1, 1 => n - 2 + n + 2 * n - 1 = 4 * n - 3
      // 1 .... 2 * n - 1, ... 1 => n - 1 + 2 * n - 1 = 3 * n - 2
      // s(i) =
      Sorting.quickSort(target)
      var sum = 0
      var ok = true
      var i = 0
      while (i < n && ok) {
        // x * n - y == num
        // x * n - x + 1 == num
        // x * (n - 1) = num - 1

        if (target(i) > 1) {
          if (target(i) < n) {
            ok = false
          } else if ((target(i) - 1) % (n - 1) != 0) {
            ok = false
          } else if (i > 0 && target(i) == target(i - 1)) {
            ok = false
          } else if (sum > target(i)) {
            ok = false
          }
        }
        sum += target(i)

        i += 1
      }

      ok
    }
  }
}
