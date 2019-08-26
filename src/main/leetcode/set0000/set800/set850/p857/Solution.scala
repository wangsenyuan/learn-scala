package set0000.set800.set850.p857

import scala.collection.mutable
import scala.util.Sorting

object Solution {
  def mincostToHireWorkers(quality: Array[Int], wage: Array[Int], K: Int): Double = {
    val n = quality.length
    if (n == 0) {
      0
    } else {
      val workers = quality.zip(wage).map(x => Worker(x._1, x._2))

      Sorting.quickSort(workers)(Ordering.fromLessThan((a, b) => a.quality * b.wage > a.wage * b.quality))

      val pq = mutable.PriorityQueue.empty[Int]

      var quantitySum = 0
      for {
        i <- 0 until K
      } {
        quantitySum += workers(i).quality
        pq.enqueue(workers(i).quality)
      }

      var res = workers(K - 1).wage.toDouble * quantitySum.toDouble / workers(K - 1).quality.toDouble

      for {
        i <- K until n
      } {
        val cur = workers(i)
        pq.enqueue(cur.quality)
        quantitySum += cur.quality

        val x = pq.dequeue()
        quantitySum -= x

        val tmp = cur.wage.toDouble * quantitySum.toDouble / cur.quality.toDouble
        res = res min tmp
      }

      res
    }
  }

  case class Worker(quality: Int, wage: Int)

}
