package set0000.set800.set870.p873

import scala.collection.mutable

object Solution {
  def lenLongestFibSubseq(A: Array[Int]): Int = {
    val ii = mutable.Map.empty[Int, Int]
    val n = A.length
    (0 until n).foreach(i => ii(A(i)) = i)
    var best = 0
    for {
      i <- 0 until n - 3
      j <- i + 1 until n - 2
    } {
      var x = A(i)
      var y = A(j)
      var l = 2
      while (ii.contains(x + y)) {
        l += 1
        val z = x
        x = y
        y += z
      }
      best = best max l
    }

    if (best < 3) {
      0
    } else {
      best
    }
  }
}
