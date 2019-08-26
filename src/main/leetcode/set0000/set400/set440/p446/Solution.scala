package set0000.set400.set440.p446

import scala.collection.mutable

object Solution {
  def numberOfArithmeticSlices(A: Array[Int]): Int = {
    val n = A.length

    val dp = Array.fill[mutable.Map[Long, Int]](n)(null)

    for {
      i <- A.indices
    } {
      dp(i) = mutable.Map.empty[Long, Int].withDefaultValue(0)
    }

    val nums = mutable.Map.empty[Long, Boolean].withDefaultValue(false)

    for {
      a <- A
    } {
      nums(a.toInt) = true
    }

    var res = 0
    for {
      i <- A.indices
      j <- (i - 1) to 0 by -1
    } {
      val diff = A(i).toLong - A(j).toLong
      res += dp(j)(diff)

      if (nums(A(i) + diff)) {
        dp(i)(diff) += 1 + dp(j)(diff)
      }

    }

    res
  }
}
