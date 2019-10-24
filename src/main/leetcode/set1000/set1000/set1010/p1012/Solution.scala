package set1000.set1000.set1010.p1012

import scala.collection.mutable.ArrayBuffer

object Solution {

  def numDupDigitsAtMostN(N: Int): Int = {
    if (N <= 10) {
      0
    } else {
      val pow = Array.ofDim[Int](10)
      pow(0) = 1
      (1 to 9).foreach(i => pow(i) = pow(i - 1) * 10)

      val ds = digits(N)
      val m = ds.length

      def dfs(i: Int, less: Boolean, flag: Int): Int = {
        if (i == m) {
          0
        } else {
          val d = ds(i)

          var res = 0
          if (flag == 0) {
            res += dfs(i + 1, true, 0)
          }

          var x = 0
          if (flag == 0) {
            x = 1
          }
          while (x <= d) {
            if ((flag & (1 << x)) > 0) {
              // x repeat
              if (less || x < d) {
                res += pow(m - i - 1)
              } else {
                res += N % pow(m - i - 1) + 1
              }
            } else {
              res += dfs(i + 1, less || x < d, flag | (1 << x))
            }
            x += 1
          }

          if (less) {
            //x = d + 1
            while (x <= 9) {
              if ((flag & (1 << x)) > 0) {
                // x repeat
                res += pow(m - i - 1)
              } else {
                res += dfs(i + 1, true, flag | (1 << x))
              }
              x += 1
            }
          }

          res
        }
      }

      dfs(0, false, 0)
    }
  }

  private def digits(n: Int): Array[Int] = {
    val buf = ArrayBuffer.empty[Int]
    var num = n
    while (num > 0) {
      buf += num % 10
      num /= 10
    }
    buf.reverse.toArray
  }
}
