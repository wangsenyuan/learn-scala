package set0000.set900.set990.p996

import scala.util.Sorting

object Solution {
  def numSquarefulPerms(A: Array[Int]): Int = {

    Sorting.quickSort(A)

    val n = A.length

    val N = 1 << n

    def dfs(used: Int, last: Int): Int = {
      if (used == N - 1) {
        1
      } else {
        var res = 0

        var i = 0
        while (i < n) {
          if ((used & (1 << i)) == 0) {
            if (i == 0 || (A(i) > A(i - 1) || (used & (1 << (i - 1))) > 0)) {
              if (last == -1) {
                res += dfs(used | (1 << i), A(i))
              } else {
                val x = last + A(i)
                val s = Math.sqrt(x).toInt
                if (s * s == x) {
                  res += dfs(used | (1 << i), A(i))
                }
              }
            }
          }
          i += 1
        }
        res
      }
    }

    dfs(0, -1)
  }
}
