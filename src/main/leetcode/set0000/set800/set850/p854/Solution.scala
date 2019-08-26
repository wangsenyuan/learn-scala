package set0000.set800.set850.p854

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Solution {
  def kSimilarity(A: String, B: String): Int = {
    val as = A.toCharArray
    val bs = B.toCharArray
    var n = 0
    var i = 0
    while (i < as.length) {
      if (as(i) != bs(i)) {
        as(n) = as(i)
        bs(n) = bs(i)
        n += 1
      }
      i += 1
    }

    if (n == 0) {
      0
    } else {
      // n is the length of different letters
      val N = 1 << n
      val cnt = Array.ofDim[Int](6)
      val groupBuf = ArrayBuffer.empty[(Int, Int)]
      var mask = 1
      while (mask < N) {
        (0 until 6).foreach(j => cnt(j) = 0)
        var l = 0
        i = 0
        while (i < n) {
          if ((mask & (1 << i)) > 0) {
            l += 1
            cnt(as(i) - 'a') += 1
            cnt(bs(i) - 'a') -= 1
          }
          i += 1
        }

        val can = cnt.forall(_ == 0)
        if (can) {
          // we can group positions in mask as one
          groupBuf += mask -> l
        }

        mask += 1
      }

      val groups = groupBuf.toArray

      Sorting.quickSort(groups)(Ordering.fromLessThan((a, b) => a._2 < b._2))

      val ii = mutable.Map.empty[Int, Int].withDefaultValue(-1)

      (0 until groups.length).foreach(i => ii += groups(i)._1 -> i)

      val dp = Array.fill(groups.length)(1)

      i = 0
      while (i < groups.length) {
        val cur = groups(i)
        val mask = cur._1

        var j = 0
        while (j < i) {
          val tmp = groups(j)
          val first = tmp._1
          if ((mask & first) == first) {
            val second = mask ^ first
            val k = ii(second)

            if (k >= 0) {
              dp(i) = dp(i) max (dp(j) + dp(k))
            }

          }

          j += 1
        }

        i += 1
      }

      n - dp(groups.length - 1)
    }
  }
}
