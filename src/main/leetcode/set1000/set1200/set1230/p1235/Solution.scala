package set1000.set1200.set1230.p1235

import java.util

import scala.util.Sorting

object Solution {

  case class Job(start: Int, end: Int, profit: Int)

  def jobScheduling(startTime: Array[Int], endTime: Array[Int], profit: Array[Int]): Int = {
    val n = startTime.length
    val jobs = Array.ofDim[Job](n)
    (0 until n).foreach(i => {
      jobs(i) = Job(startTime(i), endTime(i), profit(i))
    })

    Sorting.quickSort(jobs)(Ordering.by(_.end))

    val processed = new util.TreeMap[Int, Int]()

    var best = 0
    for {
      i <- 0 until n
      job = jobs(i)
    } {
      var earn = job.profit
      val x = processed.floorEntry(job.start)
      if (x != null) {
        earn += x.getValue
      }
      val y = processed.floorEntry(job.end)
      if (y != null) {
        earn = earn max y.getValue
      }
      processed.put(job.end, earn)
      best = best max earn
    }

    best
  }
}
