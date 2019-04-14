package set500.set530.p539

import scala.collection.mutable.ArrayBuffer

object Solution {
  def findMinDifference(timePoints: List[String]): Int = {
    val MOD = 24 * 60
    if (timePoints.size > MOD) {
      0
    } else {
      val buckets = Array.ofDim[Int](MOD)

      for {
        s <- timePoints
        min = parseTime(s) % MOD
      } {
        buckets(min) += 1
      }

      if (buckets.exists(_ > 1)) {
        0
      } else {
        val arr = ArrayBuffer.empty[Int]
        for {
          i <- 0 until MOD
          if (buckets(i) > 0)
        } {
          arr += i
        }
        val n = arr.length
        var best = (arr(0) + MOD - arr(n - 1)) % MOD

        for {
          i <- 1 until n
        } {
          best = (arr(i) - arr(i - 1)) min best
        }

        best
      }
    }
  }

  private def parseTime(s: String): Int = {
    val hours = s.substring(0, 2).toInt
    val mins = s.substring(3, 5).toInt
    hours * 60 + mins
  }
}
