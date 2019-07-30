package set800.set820.p823

import scala.collection.mutable
import scala.util.Sorting

object Solution {
  val MOD = (1e9 + 7).toLong
  def numFactoredBinaryTrees(A: Array[Int]): Int = {
    val dp = mutable.Map.empty[Int, Long].withDefaultValue(0)
    Sorting.quickSort(A)
    var res = 0L
    val n = A.length
    var i = 0
    while(i < n) {
      val num = A(i)
      dp(num) += 1

      var j = 0
      while(j < i && A(j) * A(j) <= num) {
        val x = A(j)

        if(num % x == 0) {
          val y = num / x
          dp(num) += dp(x) * dp(y)
          if(x != y) {
            dp(num) += dp(x) * dp(y)
          }
          dp(num) %= MOD
        }

        j += 1
      }
      res += dp(num)
      res %= MOD
      i += 1
    }

    res.toInt
  }
}
