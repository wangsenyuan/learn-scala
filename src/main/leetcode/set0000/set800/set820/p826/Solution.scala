package set0000.set800.set820.p826

import scala.util.Sorting

object Solution {
  def maxProfitAssignment(difficulty: Array[Int], profit: Array[Int], worker: Array[Int]): Int = {
    val jobs = difficulty.zip(profit).map(x => Job(x._1, x._2))
    Sorting.quickSort(jobs)(Ordering.fromLessThan((a, b) => a.difficulty < b.difficulty))

    val n = jobs.length
    val dp = Array.ofDim[Int](n)
    dp(0) = jobs(0).profit
    var i = 1
    while(i < n) {
      dp(i) = jobs(i).profit max dp(i - 1)
      i += 1
    }

    def find(d: Int): Int = {
      var left = 0
      var right = n
      while(left < right) {
        val mid = (left + right) / 2
        if(jobs(mid).difficulty > d) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      right -= 1
      if(right >= 0) {
        dp(right)
      } else {
        0
      }
    }

    var res = 0
    i = 0
    while(i < worker.length) {
      res += find(worker(i))
      i += 1
    }

    res
  }

  case class Job(difficulty: Int, profit: Int)
}
