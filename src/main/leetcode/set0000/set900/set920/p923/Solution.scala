package set0000.set900.set920.p923

import scala.util.Sorting

object Solution {

  val MOD = 1000000007

  def threeSumMulti(A: Array[Int], target: Int): Int = {
    Sorting.quickSort(A)

    val n = A.length

    val count = Array.ofDim[Int](target + 1)

    val dp = Array.ofDim[Int](n, target + 1)

    var i = 0
    while (i < n && A(i) <= target) {
      var x = A(i)
      while (x <= target) {
        val y = x - A(i)
        dp(i)(x) += count(y)
        if (dp(i)(x) >= MOD) {
          dp(i)(x) -= MOD
        }

        x += 1
      }
      count(A(i)) += 1

      i += 1
    }
    val fp = Array.ofDim[Int](target + 1)
    var ans = 0


    i = 0
    while (i < n && A(i) <= target) {
      val x = target - A(i)
      // we need to find dp(j)(x)
      ans += fp(x)
      if (ans >= MOD) {
        ans -= MOD
      }

      for {
        y <- A(i) to target
      } {
        fp(y) += dp(i)(y)
        if (fp(y) >= MOD) {
          fp(y) -= MOD
        }
      }

      i += 1
    }

    ans
  }

  //
  //  private def search(n: Int, fn: Int => Boolean): Int = {
  //    var left = 0
  //    var right = n
  //    while (left < right) {
  //      val mid = (left + right) / 2
  //      if (fn(mid)) {
  //        right = mid
  //      } else {
  //        left = mid + 1
  //      }
  //    }
  //    right
  //  }
}
